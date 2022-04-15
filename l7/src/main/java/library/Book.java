package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Book {
    private static Map<Integer, Book> books;
    private static int count = 0;
    private int id;
    private String tittle;
    private String author;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String tittle, String author, int year) {
        if (books == null) {
            books = new HashMap<>();
        }
        this.tittle = tittle;
        this.author = author;
        this.year = year;

        if (!hasBook()) {
            count++;
            this.id = count;
            books.put(this.id, this);
        }
    }

    public static ArrayList<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    private boolean hasBook() {
        return books.containsValue(this);
    }

   @Override
    public String toString() {
        return "Book{ tittle='" + tittle + '\'' + ", author='" + author + '\'' +  ", year=" + year + '}';
    }
}
