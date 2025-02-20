/**
 * This class represents a circle.  It offers all the operations mandated by the Shape interface.
 */
public class Circle extends AbstractShape {

  private double radius;

  /**
   * Construct a circle object using the given center and radius
   *
   * @param x      x coordinate of the centerimport org.junit.jupiter.api.Test; import static
   *               org.junit.jupiter.api.Assertions.*; of this circle
   * @param y      y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double x, double y, double radius) {
    super(new Point2D(x, y));
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   *
   * @param radius the radius of this circle
   */
  public Circle(double radius) {
    super(new Point2D(0, 0));
    this.radius = radius;
  }

  /**
   * Get the area of a circle
   *
   * @return the area of a circle
   */
  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  /**
   * Get the perimeter of a circle
   *
   * @return the perimeter of a circle
   */
  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  /**
   * Resize the circle based on its area
   *
   * @param factor factor of resizing
   * @return a new circle
   */
  @Override
  public Shape resize(double factor) {
    return new Circle(reference.getX(), reference.getY(), Math.sqrt(factor) *
        radius);
  }

  // create a new methods that compare the perimeter of two circles.

  /**
   * Get the center and radius of a circle
   *
   * @return the information about a circle
   */
  @Override
  public String toString() {
    return String.format("Circle with radius %.2f at position (%.2f, %.2f) \n" +
            "Its perimeter is %.2f and its area is %.2f.",
        this.radius, this.reference.getX(), this.reference.getY(),
        this.perimeter(), this.area());
  }

  public static void main(String args[]) {
    Circle cir1 = new Circle(0, 0, 4);
    Circle cir2 = new Circle(0, 0, 8);
    int res = cir1.compareTo(cir2);
    System.out.println(res);
  }
}