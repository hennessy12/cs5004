/**
 * The Shoe class represents a shoe with attributes such as type, color, brand, and size.
 * This class provides a constructor for initializing the attributes, getter methods to retrieve
 * attribute values, and a toString method to summarize the shoe details.
 */
public class Shoe {

  private String type;
  private String color;
  private String brand;
  private double size;

  /**
   * Constructs a new Shoe object with the specified type, color, brand, and size.
   *
   * @param type  the type of shoe (e.g., sneaker, boot, sandal)
   * @param color the color of the shoe (e.g., black, white, red)
   * @param brand the brand of the shoe (e.g., Nike, Adidas)
   * @param size  the size of the shoe (e.g., 9.5, 10)
   */
  public Shoe(String type, String color, String brand, double size) {
    this.type = type;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Returns the type of the shoe.
   *
   * @return the type of the shoe
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the color of the shoe.
   *
   * @return the color of the shoe
   */
  public String getColor() {
    return color;
  }

  /**
   * Returns the brand of the shoe.
   *
   * @return the brand of the shoe
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Returns the size of the shoe.
   *
   * @return the size of the shoe
   */
  public double getSize() {
    return size;
  }

  /**
   * Returns a string representation of the shoe, summarizing its attributes.
   *
   * @return a string containing the type, color, brand, and size of the shoe
   */
  @Override
  public String toString() {
    return "Shoe{" +
        "type='" + type + '\'' +
        ", color='" + color + '\'' +
        ", brand='" + brand + '\'' +
        ", size=" + size +
        '}';
  }

  public static void main (String[] args ){
    Shoe myshoe = new Shoe("sneaker","black","nike",35);

    System.out.print(myshoe);

  }
}

