package Java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class TimeDate {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        System.out.println("---------------------------------------------");

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
        System.out.println(legacyDate);
        System.out.println("---------------------------------------------");

        ZoneId.getAvailableZoneIds().forEach(zone -> System.out.print(zone + "\t"));
        // prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
        System.out.println("---------------------------------------------");
        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // false
        System.out.println("---------------------------------------------");

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239
        System.out.println("---------------------------------------------");

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        System.out.println("---------------------------------------------");

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
        System.out.println("---------------------------------------------");

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("today:" + today);
        System.out.println("tomorrow:" + tomorrow);
        System.out.println("yesterday:" + yesterday);
        System.out.println("---------------------------------------------");

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println("---------------------------------------------");

        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        System.out.println(xmas);   // 2014-12-24
        System.out.println("---------------------------------------------");

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439
        System.out.println("---------------------------------------------");

        Instant instant1 = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate1);     // Wed Dec 31 23:59:59 CET 2014
        System.out.println("---------------------------------------------");

//        DateTimeFormatter formatter =
//                DateTimeFormatter
//                        .ofPattern("MMM dd, yyyy - HH:mm");
//
//        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
//        String string = formatter.format(parsed);
//        System.out.println(string);     // Nov 03, 2014 - 07:13
    }
}
