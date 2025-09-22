package visitor_pattern.yc.ex1;

public interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
