package startegy_pattern.duck;

public class MallardDuck implements Duck, Flyable, Quackable{
    @Override
    public void quack() {
        System.out.println("MallardDuck");
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
