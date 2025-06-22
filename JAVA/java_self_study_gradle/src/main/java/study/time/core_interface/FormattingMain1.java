package study.time.core_interface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2024, 12, 31);
        System.out.println("date = " + date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formatedDate = date.format(formatter);
        System.out.println("날짜와 시간 포맷팅 = " + formatedDate);

        String input = "2030년 01월 01일";
        LocalDate localDate = LocalDate.parse(input, formatter);
        System.out.println("localDate = " + localDate);
    }
}
