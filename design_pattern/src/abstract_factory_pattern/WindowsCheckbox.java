package abstract_factory_pattern;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in windows style");
    }
}
