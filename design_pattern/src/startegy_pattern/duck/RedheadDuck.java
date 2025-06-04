package startegy_pattern.duck;

public class RedheadDuck implements Duck, Flyable, Quackable{
    @Override
    public void quack() {
        System.out.println("RedheadDuck");
    }

    @Override
    public void swim() {

    }

    @Override
    public void display() {

    }

    @Override
    public void fly() {

    }
}
