package com.company;

public abstract class BookShop {
    int price;
    String name;
    int year;
    public BookShop(int price, String name, int year) throws Exception
    {
        if (price < 0|| year < 0)
        {
            throw new Exception("Некорректные данные");
        }
        this.price = price;
        this.name = name;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book {" + "price = " + price + ", name = " + name +", year = " + year + '}';
    }
}