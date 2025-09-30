package iterator_pattern.yc;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BreadthFirstIterator implements FileSystemIterator {
    private Queue<FileSystemItem> queue = new LinkedList<>();

    public BreadthFirstIterator(Directory root) {
        queue.offer(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public FileSystemItem next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        FileSystemItem current = queue.poll();
        if(current instanceof Directory) {
            queue.addAll(((Directory) current).getContents());
        }
        return current;
    }
}
