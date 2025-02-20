import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for PerimeterComparator
 */
public class PerimeterComparatorTest {

    private Shape rec1, rec2, cir1, cir2, tri1, tri2;
    private Point2D A, B, C, D, E, F;

    // Instantiate different shapes for testing
    @BeforeEach
    public void setUp() {
        rec1 = new Rectangle(0, 0, 4, 3);
        rec2 = new Rectangle(0, 0, 9, 12);
        cir1 = new Circle(0, 0, 15);
        cir2 = new Circle(0, 0, 10);

        A = new Point2D(0, 0);
        B = new Point2D(4, 0);
        C = new Point2D(0, 3);
        tri1 = new Triangle(A, B, C);

        D = new Point2D(0, 0);
        E = new Point2D(2, 0);
        F = new Point2D(0, 2);
        tri2 = new Triangle(D, E, F);
    }

    /**
     * Test whether built-in compare() works correctly.
     */
    @Test
    public void compare() {
        PerimeterComparator comparator = new PerimeterComparator();

        // Rectangle
        assertEquals(-1, comparator.compare(rec1, rec2));
        assertNotEquals(0, comparator.compare(rec1, rec2));

        // Circle
        assertEquals(1, comparator.compare(cir1, cir2));

        // Triangle
        assertEquals(1, comparator.compare(tri1, tri2));
        assertNotEquals(0, comparator.compare(tri1, tri2));

        // Compare different shapes
        assertEquals(1, comparator.compare(cir1, rec1));
        assertEquals(-1, comparator.compare(tri1, rec1));

    }
}