package study.time.type;

import java.time.LocalDate;
import java.time.LocalTime;

public class MyLocalDateTime {
    private final LocalDate date;
    private final LocalTime time;

    public MyLocalDateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }
}
