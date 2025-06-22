package study.time.type;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MyOffsetDateTime {

    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    public MyOffsetDateTime(LocalDateTime dateTime, ZoneOffset offset) {
        this.dateTime = dateTime;
        this.offset = offset;
    }

    public static MyOffsetDateTime now() {
        return new MyOffsetDateTime(LocalDateTime.now(), ZoneOffset.UTC);
    }

    public static MyOffsetDateTime of(LocalDateTime localDateTime, ZoneOffset offset) {
        return new MyOffsetDateTime(localDateTime, offset);
    }

    public static MyOffsetDateTime ofKorea( ) {
        return new MyOffsetDateTime(LocalDateTime.now(), ZoneOffset.ofHours(9));
    }

    @Override
    public String toString() {
        return  dateTime +
                ", UTC " + offset ;
    }
}
