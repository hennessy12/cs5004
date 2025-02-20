/**
 * This class implements Shape interface.
 */
public abstract class AbstractShape implements Shape {
    protected Point2D reference;

    /**
     * Constructs an {@code AbstractShape} with the specified reference point.
     * @param reference The reference point for the shape.
     */
    public AbstractShape(Point2D reference) {
        if (reference == null) {
            throw new NullPointerException("Reference point cannot be null.");
        }
        this.reference = reference;
    }

    /**
     * Calculates the distance from the origin to the reference point of this shape.
     * @return The distance from the origin to the reference point.
     */
    @Override
    public double distanceFromOrigin() {
        return reference.distToOrigin();
    }

    /**
     * Compares this shape to another shape based on their areas.
     * @param s the object to be compared.
     * @return negative integer, zero, or a positive integer as this shape's
     *      area is less than, equal to, or greater than the specified shape's area.
     */
    @Override
    public int compareTo(Shape s) {
        if (s == null) {
            throw new NullPointerException("Shape to compare cannot be null.");
        }

        double areaThis = this.area();
        double areaOther = s.area();

        if (areaThis < areaOther) {
            return -1;
        } else if (areaOther < areaThis) {
            return 1;
        } else {
            return 0;
        }
    }

}