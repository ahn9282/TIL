package abstract_factory_pattern;

public class MacOSButton implements Button{
    @Override
    public void paint() {
        System.out.println("Rendering a button in mac os style");
    }
}
