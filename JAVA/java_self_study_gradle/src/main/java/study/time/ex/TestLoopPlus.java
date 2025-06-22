package study.time.ex;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TestLoopPlus {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);

        for (int i = 1; i <= 5; i++) {
            LocalDate nextDate = startDate.plus(2 * i, ChronoUnit.WEEKS);
            System.out.println("날짜 "+ i +" : " + startDate);
           // if(i != 5)startDate = startDate.plusWeeks(2);
        }
    }
}
