package tests;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InstantTest {

  @Test
  public void testFormatting() {
    final DateTimeFormatter isoInstant = DateTimeFormatter.ISO_DATE_TIME;
    for (int i = 0; i < 1000; i++) {
      final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
      final String formatted = isoInstant.format(now);
      //2017-07-15T16:28:23.639
      //0123456789 123456789 12
//      final String substring = formatted.substring(20, formatted.length());
//      System.out.println(formatted);
    }
  }
}
