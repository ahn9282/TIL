package flyweight_pattern.yc;

public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }
    public void read(){
        System.out.println("Reading the book titled : " + title);
    }
}
