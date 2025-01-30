/**
 * The Newshoe class represents a shoe with attributes such as type, color, brand, and size.
 * This class provides a constructor for initializing the attributes, getter methods to retrieve
 * attribute values, and a toString method to summarize the shoe details.
 */
public class Newshoe {

  private Type type;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Constructs a new Shoe object with the specified type, color, brand, and size.
   *
   * @param type  the type of shoe (e.g., SNEAKER, BOOT, SANDAL, DRESS)
   * @param color the color of the shoe (e.g., BLACK, WHITE, RED, BROWN)
   * @param brand the brand of the shoe (e.g., NIKE, ADIDAS, PUMA)
   * @param size  the size of the shoe (e.g., 9.5, 10)
   * @throws IllegalArgumentException if brand is NIKE and type is DRESS
   */
  public Newshoe(Type type, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && type == Type.DRESS) {
      throw new IllegalArgumentException("NIKE does not sell DRESS shoes.");
    }
    this.type = type;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /** Returns the type of the shoe. */
  public Type getType() {
    return type;
  }

  /** Returns the color of the shoe. */
  public Color getColor() {
    return color;
  }

  /** Returns the brand of the shoe. */
  public Brand getBrand() {
    return brand;
  }

  /** Returns the size of the shoe. */
  public double getSize() {
    return size;
  }

  /**
   * Returns a string representation of the shoe, summarizing its attributes.
   *
   * @return a formatted string containing the type, color, brand, and size of the shoe.
   */
  @Override
  public String toString() {
    String brandName;
    switch (brand) {
      case NIKE -> brandName = "Nike";
      case ADIDAS -> brandName = "Adidas";
      case PUMA -> brandName = "Puma";
      default -> brandName = brand.name();
    }

    String typeName;
    switch (type) {
      case SNEAKER -> typeName = "Sneaker";
      case BOOT -> typeName = "Boot";
      case SANDAL -> typeName = "Sandal";
      case DRESS -> typeName = "Dress Shoe";
      default -> typeName = type.name();
    }

    String colorName;
    switch (color) {
      case BLACK -> colorName = "Black";
      case WHITE -> colorName = "White";
      case RED -> colorName = "Red";
      case BROWN -> colorName = "Brown";
      default -> colorName = "Neutral";
    }

    return String.format("Shoe [Type: %s, Color: %s, Brand: %s, Size: %.1f]", typeName, colorName, brandName, size);
  }

  /** Main method for testing the class. */
  public static void main(String[] args) {
    try {
      Newshoe myShoe = new Newshoe(Type.SNEAKER, Color.BLACK, Brand.NIKE, 10);
      System.out.println(myShoe);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
