/**
 * Represents a person who owns a cat.
 */
public class Person {
  private String name;

  /**
   * Constructor for the Person class.
   * @param name The name of the person.
   */
  public Person(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the person.
   * @return The name of the person.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the person.
   * @param name The new name of the person.
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{name='" + name + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return name.equals(person.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}