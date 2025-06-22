package study.time.core_interface;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class GetTimeMain {

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);
        System.out.println("year = " + dt.get(ChronoField.YEAR));
        System.out.println("month of year = " + dt.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("day of month = " + dt.get(ChronoField.DAY_OF_MONTH));
        System.out.println("hour of day = " + dt.get(ChronoField.HOUR_OF_DAY));
        System.out.println("minute of hour = " + dt.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("second of minute = " + dt.get(ChronoField.SECOND_OF_MINUTE));

        System.out.println("편의 메서드 제공");
        System.out.println("YEAR = " + dt.getYear());
        System.out.println("MONTH_OF_YEAR = " + dt.getMonthValue());
        System.out.println("day of month  = " + dt.getDayOfMonth());
        System.out.println("minute of hour = " + dt.getHour());
        System.out.println("minute of minute = " + dt.getMinute());
        System.out.println("second of minute = " + dt.getSecond());

        System.out.println("편의 메서드에 없음");
        System.out.println("MINUTE_OF_DAY = " + dt.get(ChronoField.MINUTE_OF_DAY));
    }
}
