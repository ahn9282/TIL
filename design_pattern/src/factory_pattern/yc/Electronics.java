package factory_pattern.yc;

public class Electronics implements Product{
    @Override
    public void create() {

        System.out.println("Electronics product created.");

    }
}
