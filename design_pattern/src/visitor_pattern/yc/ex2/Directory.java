package visitor_pattern.yc.ex2;


import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
