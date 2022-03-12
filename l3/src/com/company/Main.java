package com.company;

import com.company.admin.Admin;
import com.company.admin.SortByYear;
import com.company.books.Book;
import com.company.books.Parser;
import com.company.books.Type;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws Exception {
        LOG.info("Starting program");
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

        System.out.println("----------Laba 4------------");
        final File schemaFile = new File("./files/Xsd.xsd");
        final Source xmlFile = new StreamSource("./files/Xml.xml");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<BookShop> books1;
        // parsing
        final String fileName = "D:\\универ\\стп\\stp-4sem\\l3\\files\\Xml.xml";
        Parser parser = new Parser();
        books1 = parser.CreateBookFromXml(fileName);
        books1.add(new Book(200, "titanic", 2003, Type.BOOK));
        books1.add(new Book(500,"cosmopolitan", 2016, Type.MAGAZINE));
        books1.sort(new SortByYear() ) ;// comparator

        System.out.println("--------Serialization--------------");
        String filePath = "./files/books.json";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            oos.writeObject(books1);
            System.out.println("File has been written");
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        LOG.info("JSON serialized");
        System.out.println("--------Deserialization--------------");
        var NBOOK = new ArrayList<BookShop>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
        {
            NBOOK =((ArrayList<BookShop>)ois.readObject());
            for (BookShop book:NBOOK)
            {
                System.out.println(book);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        LOG.info("JSON deserialized");
        System.out.println("----------StreamAPI---------");
        books1.stream().filter(e -> e.getPrice() < 300).forEach(System.out::println);

        LOG.info("Stream API");
        LOG.info("Final\n");
    }
}