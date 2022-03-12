package com.company.books;

import com.company.BookShop;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Parser
{
    public ArrayList<BookShop> CreateBookFromXml(String fileName)
    {
        ArrayList<BookShop> books = null;
        BookShop book = null;
        String field;
        try {
            XMLEventReader xmlr = XMLInputFactory.newInstance().createXMLEventReader(fileName,
                    new FileInputStream(fileName));
            while (xmlr.hasNext()) {
                XMLEvent event = xmlr.nextEvent();
                if (event.isStartElement()) {
                    StartElement start = event.asStartElement();
                    field = start.getName().getLocalPart();
                    event = xmlr.nextEvent();
                    switch (field)
                    {
                        case "Books":
                            books = new ArrayList<BookShop>();
                            break;
                        case "Book":
                            book = new Book();
                            break;
                        case "price":
                            book.setPrice(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "year":
                            book.setYear(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "type":
                            Book book1 = (Book) book;
                            book1.setType(event.asCharacters().getData());
                            book = book1;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: ");
                    }
                }
                if (event.isEndElement())
                {
                    EndElement endElement = event.asEndElement();
                    switch(endElement.getName().getLocalPart())
                    {
                        case "BOOK":
                            books.add(book);
                            break;
                    }
                }
            }
        }
        catch (FileNotFoundException | XMLStreamException | NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return books;
    }
}