package flyweight_pattern.yc;

public class Main1 {
    public static void main(String[] args) {
        Book book1 = BookShelf.getBook("Effective Java");
        book1.read();
        Book book2 = BookShelf.getBook("Effective Java");
        book2.read();
        Book book3 = BookShelf.getBook("Clean code");
        book3.read();

        System.out.println(book1 == book2 ? "Same book for 'Effective Java'." : "Different books for 'Effective Java'.");

    }
}
