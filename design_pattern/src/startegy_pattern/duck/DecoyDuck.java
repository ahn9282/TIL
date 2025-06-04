package startegy_pattern.duck;

public class DecoyDuck implements Duck{

    @Override
    public void swim() {

    }

    @Override
    public void display() {
        System.out.println("this is fake duck");
    }
}
