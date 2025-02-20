import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for class Rectangle
 */
public class RectangleTest {

    private Shape rec1, rec2;

    /**
     * Sets up test fixtures before each test. Initializes two Rectangle objects for testing.
     */
    @BeforeEach
    public void setUp() {
        rec1 = new Rectangle(5, 6, 2.5, 2);
        rec2 = new Rectangle(2, 3, 10, 10);
    }

    /**
     * Tests whether the Rectangle constructor properly initializes objects.
     */
    @Test
    public void testConstructors() {
        // Ensure rec1 and rec2 are not null
        assertNotNull(rec1);
        assertNotNull(rec2);
    }

    /**
     * Test whether area() work correctly.
     */
    @Test
    public void area() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Test whether perimeter() work correctly.
     */
    @Test
    public void perimeter() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Tests whether resize() work correctly.
     */
    @Test
    public void resize() {
        // Tested by ShapeTest so skipped here
    }

    /**
     * Tests whether the toString() work correctly.
     */
    @Test
    public void testToString() {
        // Tested by ShapeTest so skipped here
    }
}
