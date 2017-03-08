package tests;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class DateFormattingTest {

  @Test
  public void formatParallelTest() {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    final List<String> formatted = LongStream.range(0, 4)
      .parallel()
      .mapToObj(simpleDateFormat::format)
      .collect(Collectors.toList());

    assertEquals("00:00:00.000", formatted.get(0));
    for (int i = 0; i < formatted.size(); i++) {
      assertEquals(String.format("00:00:00.%03d", i), formatted.get(i));
    }
  }

  @Test
  public void formatNotParallelTest() {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    final List<String> formatted = LongStream.range(0, 40)
      .mapToObj(simpleDateFormat::format)
      .collect(Collectors.toList());

    assertEquals("00:00:00.000", formatted.get(0));
    for (int i = 0; i < formatted.size(); i++) {
      assertEquals(String.format("00:00:00.%03d", i), formatted.get(i));
    }
  }

}
