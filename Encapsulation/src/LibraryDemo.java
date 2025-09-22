import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId; this.title = title; this.author = author;
    }

    // Encapsulation
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public String getItemDetails() {
        return String.format("%s: %s by %s", itemId, title, author);
    }

    public abstract int getLoanDuration(); // days
}

interface Reservable {
    boolean reserveItem(String userId);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;
    private String reservedBy = null;
    public Book(String id, String t, String a) { super(id, t, a); }

    public int getLoanDuration() { return 21; }
    public boolean reserveItem(String userId) {
        if (available && reservedBy == null) { reservedBy = userId; available = false; return true; }
        return false;
    }
    public boolean checkAvailability() { return available; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String t, String a) { super(id,t,a); }
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem {
    public DVD(String id, String t, String a) { super(id,t,a); }
    public int getLoanDuration() { return 3; }
}

public class LibraryDemo {
    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
                new Book("B001","Java Programming","Author A"),
                new Magazine("M001","Tech Monthly","Editor B"),
                new DVD("D001","Movie X","Director C")
        );

        for (LibraryItem it : items) {
            System.out.printf("%s -> Loan days: %d%n", it.getItemDetails(), it.getLoanDuration());
        }

        // Reserving the book
        Book book = (Book)items.get(0);
        System.out.println("Reserve success: " + book.reserveItem("user123"));
        System.out.println("Available now? " + book.checkAvailability());
    }
}
