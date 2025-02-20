/**
 * This class represents a triangle, extending the AbstractShape class.
 * It provides methods for calculating the perimeter, area, and resizing the triangle.
 */
public class Triangle extends AbstractShape {

    private Point2D X, Y, Z;

    /**
     * Constructors of a Triangle with the specified vertices.
     * @param X The first vertex of the triangle.
     * @param Y The second vertex of the triangle.
     * @param Z The third vertex of the triangle.
     */
    public Triangle(Point2D X, Point2D Y, Point2D Z) {
        super(X);
        if (X == null || Y == null || Z == null) {
            throw new NullPointerException("Points cannot be null");
        }

        this.X = X;
        this.Y = Y;
        this.Z = Z;

        if ((Y.getX() - X.getX()) * (Z.getY() - X.getY()) == (Z.getX() - X.getX()) * (Y.getY() - X.getY())) {
            throw new IllegalArgumentException("Three points are collinear.");
        }
    }

    /**
     * Calculating the distance between two points.
     * @param A The first point.
     * @param B The second point.
     * @return The distance between the two points.
     */
    protected double getLength(Point2D A, Point2D B) {
        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2));
    }

    /**
     * Calculate the perimeter of the triangle.
     * @return the perimeter of the triangle
     */
    @Override
    public double perimeter() {
        return getLength(X, Y) + getLength(X, Z) + getLength(Y, Z);
    }

    /**
     * Calculate the area of a triangle using Heron's formula.
     * @return The area of the triangle.
     */
    @Override
    public double area() {
        double l1 = getLength(X, Y);
        double l2 = getLength(X, Z);
        double l3 = getLength(Y, Z);
        double s = perimeter() / 2;

        return Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));
    }

    /**
     * Resizes the triangle by a given factor, keeping the first vertex fixed.
     * @param factor The scaling factor.  Must be greater than 0.
     * @return a new Triangle object
     */
    @Override
    public Shape resize(double factor){
        if (factor <= 0) {
            throw new IllegalArgumentException("Resize factor must be positive.");
        }

        // Compute the scaling factor based on the area
        double scale = Math.sqrt(factor); // Scale distances by sqrt(factor)

        double xRef = X.getX();
        double yRef = X.getY();

        // Compute new positions for Y and Z
        Point2D newY = new Point2D(
            xRef + scale * (Y.getX() - xRef),
            yRef + scale * (Y.getY() - yRef)
        );

        Point2D newZ = new Point2D(
            xRef + scale * (Z.getX() - xRef),
            yRef + scale * (Z.getY() - yRef)
        );

        return new Triangle(X, newY, newZ);
    }

    // create a new methods that compare the perimeter of two triangles.


    /**
     * Returns a string representation of the triangle.
     * @return  A string containing the coordinates of the vertices, the perimeter, and the area.
     */
    public String toString(){
        return String.format("This triangle is made up of points: (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f) \n" +
                "Its perimeter is %.2f and its area is %.2f.",
            X.getX(), X.getY(), Y.getX(), Y.getY(), Z.getX(), Z.getY(), perimeter(), area());
    }

    public static void main(String[] args) {
        Point2D A = new Point2D(0, 0);
        Point2D B = new Point2D(4, 0);
        Point2D C = new Point2D(0, 3);

        Point2D D = new Point2D(0, 0);
        Point2D E = new Point2D(8, 0);
        Point2D F = new Point2D(0, 12);

        Triangle myTri1 = new Triangle(A, B, C);
        Triangle myTri2 = new Triangle(D, E, F);

        PerimeterComparator comparator = new PerimeterComparator();
        System.out.println(comparator.compare(myTri1,myTri2));
    }
}