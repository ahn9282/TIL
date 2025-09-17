package facade_pattern.yc;

public class FacadeMain {

    public static void main(String[] args) {
        FileSystemFacade facade = new FileSystemFacade();

        boolean writeSuccess = facade.writeFile("test.txt", "Hello Facade Pattern!!");
        System.out.println("File write success: " + writeSuccess);

        String content = facade.readFile("test.txt");
        System.out.println("File content: " + content);

        boolean deleteSuccess = facade.deleteFile("test.txt");
        System.out.println("File delete success: " + deleteSuccess);

    }
}
