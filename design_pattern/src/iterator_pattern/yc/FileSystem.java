package iterator_pattern.yc;

public class FileSystem {
    private Directory root;

    public FileSystem(Directory root) {
        this.root = root;
    }

    public FileSystemIterator depthFirstIterator(){
        return new DepthFirstIterator(root);
    }

    public FileSystemIterator breadthFirstIterator() {
        return new BreadthFirstIterator(root);
    }
}
