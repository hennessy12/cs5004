/**
 * This class represents an empty node in a list of books.
 */
public class EmptyNode implements IListOfBooks {

  /**
   * Returns the count of books in the list, which is zero for an empty node.
   *
   * @return 0, as this node represents an empty list.
   */
  @Override
  public int count() {
    return 0;
  }

  /**
   * Returns the total price of books in the list, which is 0 for an empty node.
   *
   * @return 0.0f, as there are no books.
   */
  @Override
  public float totalPrice() {
    return 0.0f;
  }

  /**
   * Returns a new empty list as there are no books to filter.
   *
   * @param year the year before which books should be included.
   * @return an EmptyNode, since there are no books.
   */
  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode();
  }

  /**
   * Returns a new list with the given book as the first element.
   *
   * @param book the book to be added to the list.
   * @return an ElementNode containing the book.
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, new EmptyNode());
  }

  /**
   * Returns a string representation of the empty list.
   *
   * @return "Empty List" as this node represents an empty list.
   */
  @Override
  public String toString() {
    return "Empty List";
  }
}
