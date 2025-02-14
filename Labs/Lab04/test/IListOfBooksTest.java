import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the IListOfBooks implementation.
 */
public class IListOfBooksTest {

  @Test
  public void testEmptyNodeCount() {
    IListOfBooks emptyList = new EmptyNode();
    assertEquals(0, emptyList.count());
  }

  @Test
  public void testEmptyNodeTotalPrice() {
    IListOfBooks emptyList = new EmptyNode();
    assertEquals(0.0f, emptyList.totalPrice(), 0.001);
  }

  @Test
  public void testEmptyNodeAllBefore() {
    IListOfBooks emptyList = new EmptyNode();
    assertTrue(emptyList.allBefore(2000) instanceof EmptyNode);
  }

  @Test
  public void testEmptyNodeAddAtEnd() {
    IListOfBooks emptyList = new EmptyNode();
    Book book = new Book("Test Book", "Author", 1999, 20.0f);
    IListOfBooks newList = emptyList.addAtEnd(book);
    assertTrue(newList instanceof ElementNode);
    assertEquals(1, newList.count());
  }

  @Test
  public void testEmptyNodeToString() {
    IListOfBooks emptyList = new EmptyNode();
    assertEquals("Empty List", emptyList.toString());
  }

  @Test
  public void testElementNodeCount() {
    Book book = new Book("Test Book", "Author", 1999, 20.0f);
    IListOfBooks list = new ElementNode(book, new EmptyNode());
    assertEquals(1, list.count());
  }

  @Test
  public void testElementNodeTotalPrice() {
    Book book = new Book("Test Book", "Author", 1999, 20.0f);
    IListOfBooks list = new ElementNode(book, new EmptyNode());
    assertEquals(20.0f, list.totalPrice(), 0.001);
  }

  @Test
  public void testElementNodeAllBefore() {
    Book book1 = new Book("Old Book", "Author A", 1980, 15.0f);
    Book book2 = new Book("New Book", "Author B", 2010, 25.0f);
    IListOfBooks list = new ElementNode(book1, new ElementNode(book2, new EmptyNode()));

    IListOfBooks filteredList = list.allBefore(2000);
    assertEquals(1, filteredList.count());
    assertTrue(filteredList.toString().contains("Old Book"));
  }

  @Test
  public void testElementNodeAddAtEnd() {
    Book book1 = new Book("First Book", "Author A", 2000, 15.0f);
    Book book2 = new Book("Second Book", "Author B", 2010, 25.0f);
    IListOfBooks list = new ElementNode(book1, new EmptyNode());

    IListOfBooks updatedList = list.addAtEnd(book2);
    assertEquals(2, updatedList.count());
    assertTrue(updatedList.toString().contains("Second Book"));
  }

  @Test
  public void testElementNodeToString() {
    Book book = new Book("Book Title", "Author", 2005, 30.0f);
    IListOfBooks list = new ElementNode(book, new EmptyNode());
    assertEquals("Title: Book Title Author: Author Year: 2005 Price: 30.00 -> Empty List", list.toString());
  }
}
