package date;

import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static date.DateExtractor.extract;
import static org.junit.Assert.assertEquals;

public class DateExtractorTest {

  private final String longString = IntStream.range(0, 1000).mapToObj(i -> "a").collect(Collectors.joining());

  @Test
  public void extractEmpty() throws Exception {
    assertEquals(Collections.emptyList(), extract(""));
  }

  @Test
  public void extractJustDate() throws Exception {
    final List<Date> extract = extract("00:00 01.01.1970");
    assertEquals(1, extract.size());
    assertEquals(new Date(0), extract.get(0));
  }

  @Test
  public void extractFromLongString() throws Exception {
    String text =
      longString + "00:00 01.01.1970" +
        longString + "00:01 01.01.1970" +
        longString + "00:02 01.01.1970" +
        longString + "00:03 01.01.1970" +
        longString + "00:04 01.01.1970" +
        longString + "00:05 01.01.1970";

    final List<Date> extract = extract(text);
    assertEquals(6, extract.size());
    assertEquals(new Date(0), extract.get(0));
    assertEquals(new Date(60 * 1000), extract.get(1));
    assertEquals(new Date(60 * 2000), extract.get(2));
    assertEquals(new Date(60 * 3000), extract.get(3));
    assertEquals(new Date(60 * 4000), extract.get(4));
    assertEquals(new Date(60 * 5000), extract.get(5));
  }

}