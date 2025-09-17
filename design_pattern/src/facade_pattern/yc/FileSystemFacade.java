package facade_pattern.yc;

import java.io.IOException;

public class FileSystemFacade {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private FileDeleter fileDeleter;

    public FileSystemFacade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileDeleter = new FileDeleter();
    }

    public String readFile(String filePath) {
        try {
            return fileReader.readFile(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public boolean writeFile(String filePath, String content) {
        try {
            fileWriter.writeFile(filePath, content);
            return true;
        } catch (IOException e){
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFile(String filePath){
        try {
            return fileDeleter.deleteFile(filePath);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            return false;
        }
    }
}
