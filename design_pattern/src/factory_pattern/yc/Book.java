package factory_pattern.yc;

public class Book implements Product {
    @Override
    public void create() {
        System.out.println( "Book product created.");
    }
}
