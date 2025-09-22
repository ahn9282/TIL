package visitor_pattern.yc.ex2;


public class File implements FileSystemElement {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public File(long size) {
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
