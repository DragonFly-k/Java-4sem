package com.company.admin;
import com.company.BookShop;
import java.util.Comparator;

public class SortByYear implements Comparator<BookShop> {

    @Override
    public int compare(BookShop o1, BookShop o2) {
        return Integer.compare(o1.getYear(), o2.getYear());
    }
}