package visitor_pattern.yc.ex2;

public class FileSearchVisitor implements Visitor {
    private String searchFileName;
    private File foundFile;

    public FileSearchVisitor(String searchFileName) {
        this.searchFileName = searchFileName;
    }

    public File getFoundFile() {
        return foundFile;
    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(searchFileName)){
            foundFile = file;
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()){
            element.accept(this);
        }
    }
}
