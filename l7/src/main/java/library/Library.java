package library;

import java.util.ArrayList;

public class Library implements ILibrary{
    private final ArrayList<Book> library;

    public Library() {
        library = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        library.add(book);
    }

    @Override
    public void removeBook(Book book) {
        library.remove(book);
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }
}