package visitor_pattern.yc.ex2;


public interface FileSystemElement {
    void accept(Visitor visitor);
}
