package study.time.core_interface;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.of(2024, 12, 31, 13, 30, 49);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(formatter);
        System.out.println("format = " + format);
        System.out.println("now = " + now);


        String dateTimeString = "2040-01-01 11:30:00";
        LocalDateTime.parse(dateTimeString, formatter);
        System.out.println("dateTimeString = " + dateTimeString);
    }
}
