package startegy_pattern.fly;

public class FLyNoWay implements Flyable{
    @Override
    public void fly() {
        System.out.println("i can't fly!!!");
    }
}
