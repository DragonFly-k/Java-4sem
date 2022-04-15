
import library.Book;
import library.Library;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class LibraryTest extends Assert {
    Book book = new Book("Harry Potter", "J.K. Rowling", 1997);
    Book book1 = new Book("Lord of the Rings", "J.R.R. Tolkien", 1954);

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @Test(groups = {"unit"})
    public void testAddBooks() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);
        Assert.assertNotNull(books);
    }

    @Test(timeOut = 1000)
    public void testCompareBooks() {
        ArrayList<Book> books = Book.getBooks();
        Library library = new Library();
        library.addBook(book);
        library.addBook(book1);
        Assert.assertEquals(books, library.getLibrary());
    }

    @Test(groups = {"unit"})
    public void testRemoveBook() throws NullPointerException {
        Library library = new Library();
        library.addBook(book);
        library.removeBook(book);
        Assert.assertNotNull(library.getLibrary());
    }

    @Test(enabled = false)
    public void testAddBooksIgnore() {
        ArrayList<Book> books = Book.getBooks();
        books.forEach(System.out::println);
        Assert.assertNotNull(books);
    }
}