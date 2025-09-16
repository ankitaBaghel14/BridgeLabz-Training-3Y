import java.util.*;

class Book {
    String title, author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String toString() {
        return title + " by " + author;
    }
}

class Library {
    String name;
    ArrayList<Book> books = new ArrayList<>();
    Library(String name) {
        this.name = name;
    }
    void addBook(Book b) {
        books.add(b);
    }
    void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            System.out.println(" - " + b);
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Book b2 = new Book("C++", "Bjarne");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b1); // same book in another library

        lib1.showBooks();
        lib2.showBooks();
    }
}
