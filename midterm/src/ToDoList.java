import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Concrete Class to implement a Simple "To Do" list consisting of ToDoItems
 */
public class ToDoList {
  private List<ToDoItem> myToDoList;

  /** Constructor, creates a new, empty ToDoList */
  public ToDoList() {
    myToDoList = new LinkedList<>();
  }

  /** Adds a new ToDoItem to the list */
  public void addItem(ToDoItem itm) {
    myToDoList.add(itm);
  }

  /** Gets a ToDoItem from index position i */
  ToDoItem getItem(int i) throws IndexOutOfBoundsException {
    return myToDoList.get(i);
  }

  /** Removes all occurrences of a ToDoItem */
  boolean remove(ToDoItem itm) {
    return myToDoList.remove(itm);
  }

  /** Returns the size of the ToDoList */
  int size() {
    return myToDoList.size();
  }

  /** Sorts items by importance */
  void sortByImportance() {
    Collections.sort(myToDoList);
  }

  /** Sorts items by urgency */
  void sortByUrgency() {
    myToDoList.sort(new UrgencyComparator());
  }

  /** Returns a string representation of the ToDoList */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{\n");
    for (ToDoItem anItem : myToDoList) {
      sb.append(anItem.toString()).append("\n");
    }
    return sb.append("}").toString();
  }
}
