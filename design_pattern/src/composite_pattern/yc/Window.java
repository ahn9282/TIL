package composite_pattern.yc;

import java.util.ArrayList;
import java.util.List;

public class Window implements UIComponent {
    private String title;
    private List<UIComponent> components = new ArrayList<>();

    public Window(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println("Window : " + title);
        components.forEach(UIComponent::render);
    }

    @Override
    public void add(UIComponent component) {
        components.add(component);
    }

    @Override
    public void remove(UIComponent component) {
        components.remove(component);
    }
}
