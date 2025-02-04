import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
  @Test
  void testValidTriangle() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 0);
    Point p3 = new Point(0, 4);

    Triangle triangle = new Triangle(p1, p2, p3);

    assertEquals(12.0, triangle.perimeter(), 0.001);
    assertEquals(6.0, triangle.area(), 0.001);
  }

  @Test
  void testDegenerateTriangle() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(1, 1);
    Point p3 = new Point(2, 2);

    Triangle triangle = new Triangle(p1, p2, p3);

    assertEquals(2 * Math.sqrt(2) + 2, triangle.perimeter(), 0.001);
    assertEquals(0.0, triangle.area(), 0.001);
  }

  @Test
  void testInvalidTriangle() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Point p3 = new Point(1, 1);

    assertThrows(IllegalArgumentException.class, () -> new Triangle(p1, p2, p3));
  }

  @Test
  void testToString() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 0);
    Point p3 = new Point(0, 4);

    Triangle triangle = new Triangle(p1, p2, p3);

    assertEquals("Triangle[p1=(0.00, 0.00), p2=(3.00, 0.00), p3=(0.00, 4.00)]", triangle.toString());
  }

  @Test
  void testCompareTo() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 0);
    Point p3 = new Point(0, 4);

    Triangle triangle1 = new Triangle(p1, p2, p3);
    Triangle triangle2 = new Triangle(p1, new Point(6, 0), new Point(0, 8));
    Triangle triangle3 = new Triangle(p1, p2, p3); // New but identical triangle

    assertTrue(triangle1.compareTo(triangle2) < 0); // triangle1 is smaller
    assertTrue(triangle2.compareTo(triangle1) > 0); // triangle2 is larger
    assertEquals(0, triangle1.compareTo(triangle3)); // two identical triangles
  }

}