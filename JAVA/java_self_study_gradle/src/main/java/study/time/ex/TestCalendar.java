package study.time.ex;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class TestCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("년도를 입력하세요 : ");
        int year = sc.nextInt();
        System.out.print("월을 입력하세요 : ");
        int month = sc.nextInt();

        LocalDate dt = LocalDate.of(year, month, 1);
        LocalDate lastDayMonth = dt.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayMonth = " + lastDayMonth);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < lastDayMonth.getDayOfMonth(); i++) {

            int dayOfWeek = dt.getDayOfWeek().getValue();
            int day = dt.getDayOfMonth();
            if(i ==0){
                for(int j=0;j<dayOfWeek;j++){
                    sb.append("   ");
                }
            }

            sb.append(String.format("%2d", day));

            sb.append(" ");
            if(dayOfWeek == 6){
                sb.append("\n");
            }
            dt = dt.plus(1, ChronoUnit.DAYS);
        }
        System.out.println(sb.toString());
    }
}
