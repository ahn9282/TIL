package visitor_pattern.yc.ex2;

public interface Visitor {
    void visit(File file);
    void visit(Directory directory);
}
