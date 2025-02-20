import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit5 version of ShapeTest
 */
public class ShapeTest {

    private Shape rec1, rec2, cir1, cir2, tri1, tri2;
    private Point2D A, B, C, D, E, F;

    @BeforeEach
    public void setUp() {
        rec1 = new Rectangle(5, 6, 2.5, 2);
        rec2 = new Rectangle(2, 3, 10, 10);

        cir1 = new Circle(3, 4, 5);
        cir2 = new Circle(10.32, 10.43, 10);

        A = new Point2D(0, 0);
        B = new Point2D(4, 0);
        C = new Point2D(0, 3);
        tri1 = new Triangle(A, B, C);

        D = new Point2D(0, 0);
        E = new Point2D(2, 0);
        F = new Point2D(0, 2);
        tri2 = new Triangle(D, E, F);
    }

    @Test
    void distanceFromOrigin() {
        // Tested by Point2D so skipped here
    }

    /**
     * Tests whether the area methods work correctly for all shapes
     */
    @Test
    public void area() {
        //Rectangle
        assertEquals(5, rec1.area(), 0.0001);
        assertEquals(100, rec2.area(), 0.0001);

        // Circle
        assertEquals(78.5397, cir1.area(), 0.0001);
        assertEquals(314.1592, cir2.area(), 0.0001);

        // Triangle
        assertEquals(6, tri1.area(), 0.0001);
        assertEquals(2, tri2.area(), 0.0001);
    }

    /**
     * Tests whether the perimeter methods work correctly for all shapes
     */
    @Test
    public void perimeter() {
        // Rectangle
        assertEquals(9, rec1.perimeter(), 0.0001);
        assertEquals(40, rec2.perimeter(), 0.0001);

        // Circle
        assertEquals(31.4159, cir1.perimeter(), 0.0001);
        assertEquals(62.8318, cir2.perimeter(), 0.0001);

        // Triangle
        assertEquals(12, tri1.perimeter());
        assertNotEquals(8, tri1.perimeter());
        assertEquals(6.82842, tri2.perimeter(), 0.001);
    }

    /**
     * Tests whether the resize methods work correctly for all shapes
     */
    @Test
    public void resize() {

        Rectangle newRec1 = (Rectangle) rec1.resize(4);
        assertEquals(4 * rec1.area(), newRec1.area(), 0.001);
        Rectangle newRec2 = (Rectangle) rec2.resize(0.1);
        assertNotEquals(0.01 * rec2.area(), newRec2.area(), 0.001);

        Circle newCir1 = (Circle) cir1.resize(10);
        assertEquals(10 * cir1.area(), newCir1.area(), 0.001);
        Circle newCir2 = (Circle) cir2.resize(0.5);
        assertNotEquals(5 * cir2.area(), newCir2.area(), 0.001);

        Triangle newTri = (Triangle) tri1.resize(2);
        assertEquals(2 * tri1.area(), newTri.area(), 0.001);
        Triangle newTri2 = (Triangle) tri2.resize(0.5);
        assertEquals(0.5 * tri2.area(), newTri2.area(), 0.001);
    }

    /**
     * Tests whether the compareTo methods work correctly for all shapes
     */
    @Test
    public void testCompareTo() {
        // Rectangle comparisons
        assertEquals(-1, rec1.compareTo(rec2));
        assertEquals(1, rec2.compareTo(rec1));

        // Circle comparisons
        assertEquals(-1, cir1.compareTo(cir2));
        assertEquals(1, cir2.compareTo(cir1));

        // Triangle comparisons
        assertEquals(1, tri1.compareTo(tri2));
        assertNotEquals(0, tri2.compareTo(tri1));

        // Comparing different shapes (Rectangle vs Circle)
        assertEquals(-1, rec1.compareTo(cir1));
        assertEquals(1, cir1.compareTo(rec1));
    }

    /**
     * Tests whether objects have been created with the correct numbers or not.
     */
    @Test
    public void testObjectData() {
        // Rectangle
        assertEquals(
            "Rectangle with width 2.50 and height 2.00 at position (5.00, 6.00) \n" +
                "Its perimeter is 9.00 and its area is 5.00.", rec1.toString()
        );
        assertEquals(
            "Rectangle with width 10.00 and height 10.00 at position (2.00, 3.00) \n" +
                "Its perimeter is 40.00 and its area is 100.00.", rec2.toString()
        );

        // Circle
        assertEquals(
            "Circle with radius 5.00 at position (3.00, 4.00) \n" +
                "Its perimeter is 31.42 and its area is 78.54.", cir1.toString()
        );
        assertEquals(
            "Circle with radius 10.00 at position (10.32, 10.43) \n" +
                "Its perimeter is 62.83 and its area is 314.16.", cir2.toString()
        );

        // Triangle
        assertEquals(
            "This triangle is made up of points: (0.00, 0.00), (4.00, 0.00), (0.00, 3.00) \n" +
                "Its perimeter is 12.00 and its area is 6.00.", tri1.toString()
        );
        assertEquals(
            "This triangle is made up of points: (0.00, 0.00), (2.00, 0.00), (0.00, 2.00) \n" +
                "Its perimeter is 6.83 and its area is 2.00.", tri2.toString()
        );
    }
}