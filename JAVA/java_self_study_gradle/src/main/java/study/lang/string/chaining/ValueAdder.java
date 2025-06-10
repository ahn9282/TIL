package study.lang.string.chaining;

public class ValueAdder {

    private int value;

    public ValueAdder add(int addValue) {
        value += addValue;
        return this;
    }

    @Override
    public String toString() {
        return "ValueAdder{" +
                "value=" + value +
                '}';
    }

    public int getValue(){
        return value;
    }
}
