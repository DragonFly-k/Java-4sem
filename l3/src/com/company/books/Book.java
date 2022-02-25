package com.company.books;
import com.company.BookShop;


public class Book extends BookShop {
    Type type;
    public Book(int price, String name, int year, Type type) throws Exception
    {
        super(price, name, year);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " type=" + type;
    }
}