import java.util.Objects;

/**
 * Represents a school-related ToDoItem
 */
public class ToDoItemSchool extends ToDoItemAbs {
  private boolean required;

  public ToDoItemSchool(String description, Importance importance, int urgency, boolean required) {
    super(description, importance, urgency);
    this.required = required;
  }

  public ToDoItemSchool(String description, Importance importance, int urgency) {
    super(description, importance, urgency);
    this.required = true;
  }

  public boolean getRequired() {
    return this.required;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof ToDoItemSchool)) return false;
    ToDoItemSchool that = (ToDoItemSchool) obj;
    return this.required == that.required &&
        this.urgency == that.urgency &&
        this.importance == that.importance &&
        this.description.equals(that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, urgency, importance, required);
  }

  @Override
  public String toString() {
    return super.toString() + " Required: " + this.getRequired();
  }
}

