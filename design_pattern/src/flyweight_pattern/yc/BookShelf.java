package flyweight_pattern.yc;

import java.util.HashMap;
import java.util.Map;

public class BookShelf {
    private static final Map<String, Book> bookshelf = new HashMap<>();

    public static Book getBook(String title){
        Book book = bookshelf.get(title);

        if (book == null) {
            book = new Book(title);
            bookshelf.put(title, book);
            System.out.println("Adding a new book to the bookshelf : " + title);

        } else {
            System.out.println("Reusing existing book from the bookshelf : " + title);
        }
        return book;
    }
}
