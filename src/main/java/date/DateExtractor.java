package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {

  private static final String DATE_FORMAT="HH:mm dd.MM.yyyy";
  private static final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
  static {
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  private static final Pattern pattern = Pattern.compile(
    "([0-2][0-9]:[0-5][0-9])\\s[0-3][0-9]\\.[0-2][0-9]\\.\\d{4}"
  );

  public static List<Date> extract(String string) throws ParseException {
    final Matcher matcher = pattern.matcher(string);
    final ArrayList<Date> result = new ArrayList<>();
    while (matcher.find()){
      final String group = matcher.group(0);
      final Date parse = format.parse(group);
      result.add(parse);
    }
    return result;
  }
}
