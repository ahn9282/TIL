package study.time.type;

import java.time.*;

public class OffsetDateTime {

    public static void main(String[] args) {
        MyOffsetDateTime nowOdt = MyOffsetDateTime.now();
        System.out.println("nowOdt = " + nowOdt);

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        System.out.println("ldt = " + ldt);
        MyOffsetDateTime odt = MyOffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
        System.out.println("odt = " + odt);

        MyOffsetDateTime kdt = MyOffsetDateTime.ofKorea();
        System.out.println("kdt = " + kdt);
    }
}
