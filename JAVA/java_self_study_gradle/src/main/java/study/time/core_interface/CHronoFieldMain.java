package study.time.core_interface;

import java.time.temporal.ChronoField;

public class CHronoFieldMain {
    public static void main(String[] args) {
        ChronoField[] values = ChronoField.values();
        for (ChronoField value : values) {
            System.out.println("value = " + value);
        }

        ChronoField monthOfYear = ChronoField.MONTH_OF_YEAR;
        ChronoField dayOfYear = ChronoField.DAY_OF_MONTH;
        System.out.println("ChronoField.MONTH_OF_YEAR = " + monthOfYear);
        System.out.println("ChronoField.DAY_OF_MONTH = " + dayOfYear);
    }
}
