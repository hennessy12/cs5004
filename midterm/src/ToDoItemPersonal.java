import java.util.Objects;

/**
 * Personal ToDo items with prepTime.
 */
public class ToDoItemPersonal extends ToDoItemAbs { // Fixed: Should extend ToDoItemAbs, not implement it.
  private final double prepTime;

  public ToDoItemPersonal(String description, Importance importance, int urgency, double prepTime) {
    super(description, importance, urgency);
    this.prepTime = prepTime;
  }

  public double getPrepTime() {
    return this.prepTime;
  }

  @Override
  public boolean equals(Object obj) { // Fixed: Incorrect method signature
    if (this == obj) return true;
    if (!(obj instanceof ToDoItemPersonal)) return false;
    ToDoItemPersonal that = (ToDoItemPersonal) obj;
    return Double.compare(this.prepTime, that.prepTime) == 0 &&
        this.urgency == that.urgency &&
        this.importance == that.importance &&
        this.description.equals(that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, urgency, importance, prepTime);
  }

  @Override
  public String toString() {
    return "ToDoItem: " + this.getDescription() +
        " Importance: " + this.getImportance() +
        " Urgency: " + this.getUrgency() +
        " PrepTime: " + this.getPrepTime();
  }
}
