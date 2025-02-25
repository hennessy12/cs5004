import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoItemSchoolTest {

  @Test
  public void testEquals() {
    ToDoItemSchool item1 = new ToDoItemSchool("Math Homework", Importance.HIGH, 5, true);
    ToDoItemSchool item2 = new ToDoItemSchool("Math Homework", Importance.HIGH, 5, true);
    ToDoItemSchool item3 = new ToDoItemSchool("Science Project", Importance.MEDIUM, 3, false);

    assertEquals(item1, item2);
    assertNotEquals(item1, item3);
  }

  @Test
  public void testHashCode() {
    ToDoItemSchool item1 = new ToDoItemSchool("Math Homework", Importance.HIGH, 5, true);
    ToDoItemSchool item2 = new ToDoItemSchool("Math Homework", Importance.HIGH, 5, true);

    assertEquals(item1.hashCode(), item2.hashCode());
  }
}
