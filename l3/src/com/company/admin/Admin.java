package com.company.admin;
import com.company.BookShop;
import com.company.books.Book;
import com.company.books.Type;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements IAdmin
{
    @Override
    public void CountPrice(ArrayList<BookShop> books) {
        int sum = 0;
        for (BookShop book: books) {
            sum+=book.getPrice();
        }
        System.out.println(sum);
    }

    @Override
    public void SortByYear (ArrayList<BookShop> books) {
        books.sort(new SortByYear());
    }

    @Override
    public void SearchBook (ArrayList<BookShop> books, String name1) {
        for (BookShop book:books)
        {
            if (book.getName().equals(name1))
            {
                System.out.println(book);
            }
        }
    }

    @Override
    public void Sold(ArrayList<BookShop> books, String name11) {
        books.removeIf(book -> book.getName().equals(name11));
    }
    @Override
    public void AddBook(ArrayList<BookShop> books, Type type) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Year: ");
        int year = in.nextInt();
        System.out.println("Price: ");
        int price  = in.nextInt();
        System.out.println("Name: ");
        String name = in.next();
        books.add(new Book(price,name, year, type));
    }
}