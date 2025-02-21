import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a Shape linked list. It has the features of sorting by area and perimeter.
 */
public class ShapeLList {

  public static void main(String[] args) {
    List<Shape> shapes = new LinkedList<>(); // Use LinkedList

    // Add shapes to the list
    shapes.add(new Circle(5.0, 6.0, 6.0));
    shapes.add(new Circle(0, 0, 7.0));
    shapes.add(new Circle(5.0, 6.0, 15.0));
    shapes.add(new Rectangle(4.0, 6.0, 6.0, 5.0));
    shapes.add(new Rectangle(0.0, 0.0, 4.0, 3.0));
    shapes.add(new Rectangle(-4.0, 3.0, 90.0, 80.0));

    // Sort shapes based on area (using Comparable)
    Collections.sort(shapes);

    // Print the sorted list by area
    System.out.println("Sorted by area:");
    for (Shape shape : shapes) {
      System.out.println("Area: " + shape.area());
    }

    // Sort shapes based on perimeter (using Comparator)
    Collections.sort(shapes, new PerimeterComparator());

    // Print the sorted list by perimeter
    System.out.println("\nSorted by perimeter:");
    for (Shape shape : shapes) {
      System.out.println("Perimeter: " + shape.perimeter());
    }

    // Sort shapes based on perimeter (using Comparator lambda expression)
    Comparator<Shape> byPeri = (s1, s2) -> Double.compare(s1.perimeter(), s2.perimeter());
    Collections.sort(shapes, byPeri);
    System.out.println("\nSorted by perimeter (lambda expression):");
    for (Shape shape : shapes) {
      System.out.println("Perimeter: " + shape.perimeter());
    }
  }
}
