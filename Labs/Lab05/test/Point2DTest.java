import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for class Point2D
 */
class Point2DTest {

    private Point2D testA, testB;

    /**
     * Instantiate two points for testing
     */
    @BeforeEach
    public void setUp() {
        testA = new Point2D(2, -3.5);
        testB = new Point2D(0, 0);
    }

    /**
     * Test whether distToOrigin() works correctly.
     */
    @Test
    public void testDistToOrigin() {
        assertEquals(4.031128, testA.distToOrigin(), 0.0001);
        assertNotEquals(3, testA.distToOrigin());
        assertEquals(0, testB.distToOrigin());
    }

    /**
     * Test whether getX() can give us correct x-coordinate.
     */
    @Test
    public void testGetX() {
        assertEquals(2, testA.getX());
        assertNotEquals(0, testA.getX());
        assertEquals(0, testB.getX());
    }

    /**
     * Test whether getX() can give us correct y-coordinate.
     */
    @Test
    public void testGetY() {
        assertEquals(-3.5, testA.getY());
        assertNotEquals(0, testA.getY());
        assertEquals(0, testB.getY());
    }
}