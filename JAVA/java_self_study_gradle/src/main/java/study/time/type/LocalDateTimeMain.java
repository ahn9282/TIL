package study.time.type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {

    public static void main(String[] args) {
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2016, 8, 16, 8, 10, 1);
        System.out.println("현재 날짜 시간 = " + nowDt);
        System.out.println("지정 날짜 시간 = " + ofDt);

        LocalDate localDate = nowDt.toLocalDate();
        LocalTime localTime = nowDt.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime ofDtPlus = ofDt.plusDays(1000);
        System.out.println("지정 날짜 시간 +  1000d = " + ofDtPlus);
        LocalDateTime ofDtPlus1Year = ofDt.plusYears(1);
        System.out.println("지정 날짜 시간 + 1년  = " + ofDtPlus1Year);

        System.out.println("현재 날짜시간이 지정 날짤시간보다 이전인가? >> " + nowDt.isBefore(ofDt));
        System.out.println("현재 날짜시간이 지정 날짤시간보다 이후인가? >> " + nowDt.isAfter(ofDt));
        System.out.println("현재 날짜시간이 지정 날짤시간보다 같은가? >> " + nowDt.isEqual(ofDt));

    }
}
