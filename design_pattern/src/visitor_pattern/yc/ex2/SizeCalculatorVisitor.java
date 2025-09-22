package visitor_pattern.yc.ex2;

public class SizeCalculatorVisitor implements Visitor {
    private long totoalSize = 0;

    @Override
    public void visit(File file) {
        totoalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()){
            element.accept(this);
        }
    }

    public long getTotalSize() {
        return totoalSize;
    }
}
