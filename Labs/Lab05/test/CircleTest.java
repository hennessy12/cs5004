import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for class circle
 */
public class CircleTest {

    private Shape cir1, cir2;

    @BeforeEach
    public void setUp() {
        cir1 = new Circle(3, 4, 5);
        cir2 = new Circle(10.32, 10.43, 10);
    }

    /**
     * Tests whether the Circle constructor properly initializes objects.
     */
    @Test
    public void testConstructors() {
        assertNotNull(cir1);
        assertNotNull(cir2);
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