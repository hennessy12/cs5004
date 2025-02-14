/**
 * This class represents a non-empty node (element) in a list of books.
 */
public class ElementNode implements IListOfBooks {
  private Book book;
  private IListOfBooks rest;

  /**
   * Constructs an ElementNode containing a book and a reference to the rest of the list.
   *
   * @param book the book contained in this node.
   * @param rest the rest of the book list.
   */
  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  /**
   * Returns the count of books in the list.
   *
   * @return the number of books in the list.
   */
  @Override
  public int count() {
    return 1 + rest.count();
  }

  /**
   * Returns the total price of all books in the list.
   *
   * @return the sum of the prices of all books in the list.
   */
  @Override
  public float totalPrice() {
    return book.getPrice() + rest.totalPrice();
  }

  /**
   * Returns a new list containing books published before the given year.
   *
   * @param year the year before which books should be included.
   * @return a list containing books before the given year.
   */
  @Override
  public IListOfBooks allBefore(int year) {
    if (book.before(year)) {
      return new ElementNode(book, rest.allBefore(year));
    } else {
      return rest.allBefore(year);
    }
  }

  /**
   * Returns a new list with the given book added at the end.
   *
   * @param book the book to be added to the list.
   * @return a new list with the book appended at the end.
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.book, rest.addAtEnd(book));
  }

  /**
   * Returns a string representation of the book list.
   *
   * @return a formatted string representation of the list.
   */
  @Override
  public String toString() {
    return book.toString() + " -> " + rest.toString();
  }
}
