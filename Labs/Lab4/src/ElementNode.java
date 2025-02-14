/**
 * This class represents a node in a list of books that contains a book and a reference to the rest of the list.
 */
public class ElementNode implements IListOfBooks {
  private Book book;
  private IListOfBooks rest;

  /**
   * Constructor for ElementNode.
   *
   * @param book the book stored in this node
   * @param rest the rest of the list
   */
  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + rest.count(); // Count this node and the rest of the list.
  }

  @Override
  public float totalPrice() {
    return book.getPrice() + rest.totalPrice(); // Sum the price of this book and the rest of the list.
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (book.before(year)) {
      return new ElementNode(book, rest.allBefore(year)); // Include this book if it was published before the given year.
    } else {
      return rest.allBefore(year); // Skip this book.
    }
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.book, rest.addAtEnd(book)); // Add the new book at the end of the list.
  }

  @Override
  public String toString() {
    return book.toString() + "\n" + rest.toString(); // Concatenate the string representation of this book and the rest of the list.
  }
}
