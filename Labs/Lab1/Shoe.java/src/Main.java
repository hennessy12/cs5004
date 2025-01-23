public class Main {
  public static void main(String[] args) {
    // Create a Shoe object
    Shoe myShoe = new Shoe("Sneaker", "Black", "Nike", 10.5);

    // Use the getter methods
    System.out.println("Type: " + myShoe.getType());
    System.out.println("Color: " + myShoe.getColor());
    System.out.println("Brand: " + myShoe.getBrand());
    System.out.println("Size: " + myShoe.getSize());

    // Print the Shoe object using toString()
    System.out.println(myShoe);
  }
}
