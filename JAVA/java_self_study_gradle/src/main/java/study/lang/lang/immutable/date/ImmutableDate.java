package study.lang.lang.immutable.date;

public class ImmutableDate {

    private final int year;
    private final int month;
    private final int day;

    public ImmutableDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public ImmutableDate withYear(int changed) {
        return new ImmutableDate(changed, this.month, this.day);
    }

    public int getMonth() {
        return month;
    }

    public ImmutableDate withMonth(int changed) {
        return new ImmutableDate(this.year, changed, this.day);
    }

    public int getDay() {
        return day;
    }

    public ImmutableDate withDay(int changed) {
        return new ImmutableDate(this.year, this.month, changed);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
