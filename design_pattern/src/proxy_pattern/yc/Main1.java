package proxy_pattern.yc;

public class Main1 {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("test.jpg");

        System.out.println("FileName : " + image.getFileName());
        System.out.println("File Extension : " + image.getFileExtension());

        image.display();
        image.display();
    }
}
