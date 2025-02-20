import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;


/**
 * test class for ShapeLList
 */
public class ShapeLListTest {

    private List<Shape> shapeList;
    private Rectangle rec1, rec2, rec3;
    private Circle c1, c2, c3;
    private Point2D A, B, C;
    private Triangle tri1;

    // Instantiate different shapes for testing
    @BeforeEach
    public void setUp() {
        shapeList = new LinkedList<>();

        rec1 = new Rectangle(0, 0, 4, 2);
        rec2 = new Rectangle(-2, -2, 8, 10);
        rec3 = new Rectangle(2, 2, 6, 3);

        c1 = new Circle(0, 0, 10);
        c2 = new Circle(0, 0, 6);
        c3 = new Circle(0, 0, 4);

        A = new Point2D(0, 0);
        B = new Point2D(3, 0);
        C = new Point2D(0, 4);

        tri1 = new Triangle(A, B, C);

        shapeList.add(rec1);
        shapeList.add(rec2);
        shapeList.add(rec3);
        shapeList.add(c1);
        shapeList.add(c2);
        shapeList.add(c3);
        shapeList.add(tri1);
    }

    /**
     * Test whether constructors are instantiated correctly.
     */
    @Test
    public void testConstructor() {
        assertNotNull(shapeList, "Shape list should be initialized");
        assertTrue(shapeList.isEmpty(), "Shape list should be empty.");
    }

    /**
     * Test whether adding objects into the linked list works correctly.
     */
    @Test
    public void testAddingShapes() {
        shapeList.add(rec1);
        shapeList.add(rec2);
        shapeList.add(rec3);
        assertEquals(3, shapeList.size());

        shapeList.add(c1);
        assertEquals(4, shapeList.size());
    }

    /**
     * Test whether removing objects into the linked list works correctly.
     */
    @Test
    public void testRemovingShapes() {
        shapeList.add(rec1);
        shapeList.add(rec2);
        shapeList.remove(rec2);
        assertEquals(1, shapeList.size());
        assertFalse(shapeList.contains(rec2));
    }

    /**
     * Test whether compareTo() works correctly.
     */
    @Test
    public void testSortbyArea() {
        assertFalse(shapeList.isEmpty());
        Collections.sort(shapeList);

        List<Double> expectedArea = Arrays.asList(6.0, 8.0, 18.0, 50.27, 80.0, 113.10, 314.16);
        List<Double> actualArea = new ArrayList<>();

        for (Shape shape : shapeList) {
            actualArea.add(Math.round(shape.area() * 100.0) / 100.0);
        }
        assertEquals(expectedArea, actualArea);
    }

    /**
     * Test whether compare() works correctly.
     */
    @Test
    public void testSortbyPeri() {
        assertFalse(shapeList.isEmpty());
        Collections.sort(shapeList, new PerimeterComparator());

        List<Double> expectedPeri = Arrays.asList(12.0, 12.0, 18.0, 25.13, 36.0, 37.70, 62.83);
        List<Double> actualPeri = new ArrayList<>();

        for (Shape shape : shapeList) {
            actualPeri.add(Math.round(shape.perimeter() * 100.0) / 100.0);
        }
        assertEquals(expectedPeri, actualPeri);
    }
}