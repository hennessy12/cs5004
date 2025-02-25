import java.util.Comparator;

/**
 * Comparator to sort ToDoItems by urgency in descending order
 */
public class UrgencyComparator implements Comparator<ToDoItem> {

  /**
   * Compares two ToDoItems based on urgency.
   *
   * @param itm1 the first object to be compared.
   * @param itm2 the second object to be compared.
   * @return a negative number if itm1 is more urgent, positive if itm2 is more urgent, and 0 if they are equal.
   */
  @Override
  public int compare(ToDoItem itm1, ToDoItem itm2) {
    return Integer.compare(itm2.getUrgency(), itm1.getUrgency()); // Descending order
  }
}

