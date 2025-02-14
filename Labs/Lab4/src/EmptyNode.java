/**
 * This class represents an empty node in a list of books.
 */
public class EmptyNode implements IListOfBooks {

  /**
   * Constructor for EmptyNode.
   */
  public EmptyNode() {
    // No initialization needed for an empty node.
  }

  @Override
  public int count() {
    return 0; // An empty list has no elements.
  }

  @Override
  public float totalPrice() {
    return 0.0f; // An empty list has a total price of 0.
  }

  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode(); // An empty list has no books before any year.
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, new EmptyNode()); // Adding a book to an empty list creates a new list with one element.
  }

  @Override
  public String toString() {
    return ""; // An empty list is represented by an empty string.
  }
}