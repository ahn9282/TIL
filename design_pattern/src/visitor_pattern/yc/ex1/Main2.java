package visitor_pattern.yc.ex1;

public class Main2 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        AreaVisitor areaVisitor = new AreaVisitor();
        PerimeterVisitor perimeterVisitor = new PerimeterVisitor();

        System.out.println("Calcurating Area : ");
        circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);

        System.out.println("\nCalcurating Perimeter : ");
        circle.accept(perimeterVisitor);
        rectangle.accept(perimeterVisitor);
    }
}
