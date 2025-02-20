/**
 * This class represents a rectangle.  It defines all the operations mandated by the Shape
 * interface
 */
public class Rectangle extends AbstractShape {

    private double width, height;

    /**
     * Constructs a rectangle object with the given location of its lower-left corner and
     * dimensions
     *
     * @param x      x coordinate of the lower-left corner of this rectangle
     * @param y      y coordinate of the lower-left corner of this rectangle
     * @param width  width of this rectangle
     * @param height height of this rectangle
     */
    public Rectangle(double x, double y, double width, double height) {
        super(new Point2D(x, y));
        this.width = width;
        this.height = height;
    }

    /**
     * Get the area of a rectangle
     *
     * @return the area of a rectangle
     */
    @Override
    public double area() {
        return this.width * this.height;
    }

    /**
     * Get the perimeter of a rectangle
     *
     * @return the perimeter of a rectangle
     */
    @Override
    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    /**
     * Resize the rectangle based on its area
     *
     * @param factor factor of resizing
     * @return a new rectangle
     */
    @Override
    public Shape resize(double factor) {
        double sqrtFactor = Math.sqrt(factor);
        return new Rectangle(
            this.reference.getX(),
            this.reference.getY(), sqrtFactor *
            this.width,
            sqrtFactor * this.height);
    }

    // create a new methods that compare the perimeter of two rectangles

    /**
     * Get the coordination of left bottom vertex, width, height of a rectangle
     *
     * @return the information about a rectangle
     */
    @Override
    public String toString() {
        return String.format(
            "Rectangle with width %.2f and height %.2f at position (%.2f, %.2f) \n" +
                "Its perimeter is %.2f and its area is %.2f.",
            this.width, this.height, this.reference.getX(), this.reference.getY(),
            this.perimeter(), this.area());
    }


    public static void main(String args[]) {
        Rectangle r1 = new Rectangle(0, 0, 2, 5);
        Rectangle r2 = new Rectangle(0, 0, 6, 8);
        PerimeterComparator comparator = new PerimeterComparator();
        int res = comparator.compare(r1, r2);
        System.out.println(res);
    }
}