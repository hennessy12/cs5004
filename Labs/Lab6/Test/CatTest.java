import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Cat class.
 */
public class CatTest {

  @Test
  public void testSetters() {
    Person owner1 = new Person("Alice");
    Cat cat = new Cat("Whiskers", 3, Color.BLACK, owner1);

    cat.setAge(4);
    assertEquals(4, cat.getAge(), "Age should be updated to 4");

    Person owner2 = new Person("Bob");
    cat.setOwner(owner2);
    assertEquals(owner2, cat.getOwner(), "Owner should be updated to Bob");
  }

  @Test
  public void testEquals() {
    Person owner1 = new Person("Alice");
    Person owner2 = new Person("Bob");

    Cat cat1 = new Cat("Whiskers", 3, Color.BLACK, owner1);
    Cat cat2 = new Cat("Whiskers", 3, Color.BLACK, owner1);
    Cat cat3 = new Cat("Mittens", 2, Color.WHITE, owner2);

    // Test equality
    assertTrue(cat1.equals(cat2), "Cats with the same properties should be equal");
    assertFalse(cat1.equals(cat3), "Cats with different properties should not be equal");
  }

  @Test
  public void testHashCode() {
    Person owner1 = new Person("Alice");
    Person owner2 = new Person("Bob");

    Cat cat1 = new Cat("Whiskers", 3, Color.BLACK, owner1);
    Cat cat2 = new Cat("Whiskers", 3, Color.BLACK, owner1);
    Cat cat3 = new Cat("Mittens", 2, Color.WHITE, owner2);

    // Test hash codes
    assertEquals(cat1.hashCode(), cat2.hashCode(), "Equal cats should have the same hash code");
    assertNotEquals(cat1.hashCode(), cat3.hashCode(), "Unequal cats should have different hash codes");
  }
}