package flyweight_pattern.yc;

public class ConcreteFont implements Font {
    private String font;
    private int size;
    private String color;

    public ConcreteFont(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    @Override
    public void apply(String text) {
        System.out.println("Text : " + text + "'with Font : " + font + ", Size : " + size + ", Color : " + color);
    }
}
