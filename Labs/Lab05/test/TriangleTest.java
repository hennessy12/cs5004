import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for class Triangle
 */
class TriangleTest {

    private Point2D A, B, C, D, E, F;
    private Triangle triA, triB;

    /**
     * Instantiate two triangles for testing
     */
    @BeforeEach
    public void setUp() {
        A = new Point2D(0, 0);
        B = new Point2D(4, 0);
        C = new Point2D(0, 3);
        triA = new Triangle(A, B, C);

        D = new Point2D(0, 0);
        E = new Point2D(2, 0);
        F = new Point2D(0, 2);
        triB = new Triangle(D, E, F);
    }

    /**
     * Test constructors
     */
    @Test
    public void testNullPoints() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Triangle(new Point2D(1, 1), null, new Point2D(2, 2));
        });
        assertEquals("Points cannot be null", exception.getMessage());
    }

    /**
     * Test constructors with collinear points
     */
    @Test
    public void testCollinear() {
        // Check if points are correctly assigned
        Point2D P1 = new Point2D(0, 0);
        Point2D P2 = new Point2D(0, 1);
        Point2D P3 = new Point2D(0, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(P1, P2, P3);
        });
        assertEquals("Three points are collinear.", exception.getMessage());
    }


    /**
     * Test whether getLength() work correctly.
     */
    @Test
    public void testGetLength() {
        assertEquals(4, triA.getLength(A, B));
        assertNotEquals(5, triA.getLength(A, C));
        assertEquals(2.82842, triA.getLength(E, F), 0.0001);
    }

    /**
     * Test whether getPerimeter() work correctly.
     */
    @Test
    public void testPerimeter() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Test whether area() work correctly.
     */
    @Test
    public void testArea() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Test whether resize() work correctly.
     */
    @Test
    public void testResize() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Test whether toString() work correctly.
     */
    @Test
    public void testToString() {
        // Tested by ShapeTest so skipped here
    }
}