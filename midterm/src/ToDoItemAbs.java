public abstract class ToDoItemAbs implements ToDoItem, Comparable<ToDoItem> {
  protected String description;
  protected int urgency;
  protected Importance importance;

  /**
   * Constructor for a ToDoItemAbs object.
   *
   * @param description A string describing the item.
   * @param importance  The importance level (LOW, MEDIUM, HIGH).
   * @param urgency     The urgency level (higher is more urgent).
   */
  public ToDoItemAbs(String description, Importance importance, int urgency) {
    this.description = description;
    this.importance = importance;
    this.urgency = urgency;
  }

  /**
   * Returns the description of the ToDoItem.
   *
   * @return The description as a String.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns the importance level.
   *
   * @return Importance enum value (LOW, MEDIUM, HIGH).
   */
  @Override
  public Importance getImportance() {
    return this.importance;
  }

  /**
   * Returns the urgency level.
   *
   * @return The urgency as an integer.
   */
  @Override
  public int getUrgency() {
    return this.urgency;
  }

  /**
   * Sets a new urgency level.
   *
   * @param urgency The new urgency value.
   */
  public void setUrgency(int urgency) {
    this.urgency = urgency;
  }

  /**
   * Compares this ToDoItem with another based on importance.
   *
   * @param other The ToDoItem to compare.
   * @return A negative number if this is less important, positive if more important, 0 if equal.
   */
  @Override
  public int compareTo(ToDoItem other) {
    return Integer.compare(this.importance.ordinal(), other.getImportance().ordinal());
  }
}
