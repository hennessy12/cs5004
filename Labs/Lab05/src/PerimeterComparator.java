import java.util.Comparator;

/**
 * This class implements Java built-in interface, and provides a function to compare two objects.
 */
public class PerimeterComparator implements Comparator<Shape> {

    public int compare(Shape a, Shape b){
        if (a.perimeter() < b.perimeter()){
            return -1;
        } else if (a.perimeter() == b.perimeter()){
            return 0;
        } else {
            return 1;
        }
    }
}
