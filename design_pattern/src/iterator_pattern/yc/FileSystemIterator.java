package iterator_pattern.yc;

public interface FileSystemIterator {
    boolean hasNext();

    FileSystemItem next();
}
