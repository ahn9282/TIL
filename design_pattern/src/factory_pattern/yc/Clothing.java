package factory_pattern.yc;

public class Clothing implements Product{
    @Override
    public void create() {
        System.out.println("Clothing product created.");

    }
}
