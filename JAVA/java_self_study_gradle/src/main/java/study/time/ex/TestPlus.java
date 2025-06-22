package study.time.ex;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestPlus {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2024, 01, 01, 0, 0, 0);
        now = now.plusYears(1).plusMonths(2).plusDays(3).plusHours(4);
        System.out.println("now = " + now);
    }
}
