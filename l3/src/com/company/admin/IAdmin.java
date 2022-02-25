package com.company.admin;
import com.company.BookShop;
import com.company.books.Type;

import java.util.ArrayList;

public interface IAdmin {
    void CountPrice(ArrayList<BookShop> books);
    void SortByYear(ArrayList<BookShop> books);
    void SearchBook(ArrayList<BookShop> books, String name1);
    void Sold(ArrayList<BookShop> books, String name11);
    void AddBook(ArrayList<BookShop> books,Type type) throws Exception;
}