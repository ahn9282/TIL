package abstract_factory_pattern;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Rendering a button in windows style");
    }
}
