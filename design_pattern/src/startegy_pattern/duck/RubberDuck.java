package startegy_pattern.duck;

public class RubberDuck implements Duck, Flyable, Quackable{
    @Override
    public void quack() {
        System.out.println("RubberDuck");
    }

    @Override
    public void swim() {

    }

    @Override
    public void display() {
        System.out.println("it's seem duck of rubber");
    }

    @Override
    public void fly() {

    }
}
