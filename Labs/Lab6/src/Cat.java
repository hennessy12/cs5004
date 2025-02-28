/**
 * Represents a cat with a name, age, color, and owner.
 */
public class Cat {
  private String name;
  private int age;
  private Color color;
  private Person owner;

  /**
   * Constructor for the Cat class.
   * @param name The name of the cat.
   * @param age The age of the cat in years.
   * @param color The color of the cat.
   * @param owner The owner of the cat.
   */
  public Cat(String name, int age, Color color, Person owner) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.owner = owner;
  }

  /**
   * Gets the name of the cat.
   * @return The name of the cat.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the age of the cat.
   * @return The age of the cat.
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age of the cat.
   * @param age The new age of the cat.
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Gets the color of the cat.
   * @return The color of the cat.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Gets the owner of the cat.
   * @return The owner of the cat.
   */
  public Person getOwner() {
    return owner;
  }

  /**
   * Sets the owner of the cat.
   * @param owner The new owner of the cat.
   */
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return "Cat{name='" + name + "', age=" + age + ", color=" + color + ", owner=" + owner + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cat cat = (Cat) o;
    return age == cat.age &&
        name.equals(cat.name) &&
        color == cat.color &&
        owner.equals(cat.owner);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, age, color, owner);
  }
}