package flyweight_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        Font font1 = FontFactory.getFont("Arial", 12, "Black");
        font1.apply("Hello World");

        Font font2 = FontFactory.getFont("Arial", 12, "Black");
        font2.apply("Flyweight Pattern");

        Font font3 = FontFactory.getFont("Times New Roman", 14, "Blue");
        font3.apply("Design Pattern");

        Font font4 = FontFactory.getFont("Arial", 12, "Black");
        font4.apply("Another Text");
    }
}
