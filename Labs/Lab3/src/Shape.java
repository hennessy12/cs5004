public abstract class Shape implements Comparable<Shape> {
  public abstract double area();

  public abstract double perimeter();

  @Override
  public int compareTo(Shape other) {
    return Double.compare(this.area(), other.area());
  }
}
