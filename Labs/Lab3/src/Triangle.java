import java.util.Objects;

public class Triangle extends Shape {
  private final Point p1;
  private final Point p2;
  private final Point p3;

  public Triangle(Point p1, Point p2, Point p3) {
    if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
      throw new IllegalArgumentException("Two or more points are identical. A valid triangle cannot be constructed.");
    }

    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  @Override
  public double area() {
    double a = distance(p1, p2);
    double b = distance(p2, p3);
    double c = distance(p1, p3);

    // Heron's formula
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  @Override
  public double perimeter() {
    double a = distance(p1, p2);
    double b = distance(p2, p3);
    double c = distance(p1, p3);

    return a + b + c;
  }

  private double distance(Point a, Point b) {
    return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
  }

  @Override
  public String toString() {
    return String.format("Triangle[p1=%s, p2=%s, p3=%s]", p1, p2, p3);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Triangle triangle = (Triangle) o;
    return Objects.equals(p1, triangle.p1) &&
        Objects.equals(p2, triangle.p2) &&
        Objects.equals(p3, triangle.p3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(p1, p2, p3);
  }
}