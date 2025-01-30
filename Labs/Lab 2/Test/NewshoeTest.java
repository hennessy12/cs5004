import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Newshoe class using JUnit5.
 */
public class NewshoeTest {

  @Test
  void testConstructorValidShoe() {
    Newshoe shoe = new Newshoe(Type.SNEAKER, Color.BLACK, Brand.NIKE, 10);
    assertEquals(Type.SNEAKER, shoe.getType());
    assertEquals(Color.BLACK, shoe.getColor());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(10, shoe.getSize());
  }

  @Test
  void testConstructorNikeDressThrowsException() {
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        new Newshoe(Type.DRESS, Color.BROWN, Brand.NIKE, 9)
    );
    assertEquals("NIKE does not sell DRESS shoes.", exception.getMessage());
  }

  @Test
  void testToStringFormatting() {
    Newshoe shoe = new Newshoe(Type.BOOT, Color.RED, Brand.PUMA, 11);
    String expected = "Shoe [Type: Boot, Color: Red, Brand: Puma, Size: 11.0]";
    assertEquals(expected, shoe.toString());
  }
}
