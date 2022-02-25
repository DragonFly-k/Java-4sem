package com.company;
import com.company.admin.Admin;
import com.company.admin.SortByYear;
import com.company.books.Book;
import com.company.books.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BookShop> books = new ArrayList<>();
        books.add(new Book(100,"H-Day", 2200, Type.POSTCARD));
        books.add(new Book(200, "titanic", 2003, Type.BOOK));
        books.add(new Book(500,"cosmopolitan", 2016, Type.MAGAZINE));
        System.out.println("-----------------------------------------------------");
        for (BookShop book:books) {
            System.out.println(book);
        }
        System.out.println("-----------------------------------------------------");
        books.sort(new SortByYear());
        for (BookShop book:books)
        {
            System.out.println(book);
        }
        System.out.println("-----------------------------------------------------");
        Admin admin =new Admin();
        admin.CountPrice(books);
        admin.SearchBook(books, "H-Day");
        System.out.println("-----------------------------------------------------");
        admin.Sold(books,"titanic");
        for (BookShop book:books)
        {
            System.out.println(book);
        }
        System.out.println("-----------------------------------------------------");
        admin.AddBook(books,Type.BOOK);
        for (BookShop book:books)
        {
            System.out.println(book);
        }
    }
}