import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the IListOfBooks interface implementations.
 */
public class IListOfBooksTest {

  @Test
  public void testEmptyNodeCount() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.count());
  }

  @Test
  public void testEmptyNodeTotalPrice() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0.0f, empty.totalPrice(), 0.001);
  }

  @Test
  public void testEmptyNodeAllBefore() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.allBefore(2000);
    assertEquals(0, result.count());
  }

  @Test
  public void testEmptyNodeAddAtEnd() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.addAtEnd(new Book("Title", "Author", 1999, 19.99f));
    assertEquals(1, result.count());
  }

  @Test
  public void testEmptyNodeToString() {
    IListOfBooks empty = new EmptyNode();
    assertEquals("", empty.toString());
  }

  @Test
  public void testElementNodeCount() {
    IListOfBooks list = new ElementNode(new Book("Title1", "Author1", 1999, 19.99f), new EmptyNode());
    assertEquals(1, list.count());
  }

  @Test
  public void testElementNodeTotalPrice() {
    IListOfBooks list = new ElementNode(new Book("Title1", "Author1", 1999, 19.99f), new EmptyNode());
    assertEquals(19.99f, list.totalPrice(), 0.001);
  }

  @Test
  public void testElementNodeAllBefore() {
    IListOfBooks list = new ElementNode(new Book("Title1", "Author1", 1999, 19.99f), new EmptyNode());
    IListOfBooks result = list.allBefore(2000);
    assertEquals(1, result.count());
  }

  @Test
  public void testElementNodeAddAtEnd() {
    IListOfBooks list = new ElementNode(new Book("Title1", "Author1", 1999, 19.99f), new EmptyNode());
    IListOfBooks result = list.addAtEnd(new Book("Title2", "Author2", 2001, 29.99f));
    assertEquals(2, result.count());
  }

  @Test
  public void testElementNodeToString() {
    IListOfBooks list = new ElementNode(new Book("Title1", "Author1", 1999, 19.99f), new EmptyNode());
    String expected = "Title: Title1 Author: Author1 Year: 1999 Price: 19.99\n";
    assertEquals(expected, list.toString());
  }
}
