import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

  @Test
  void testConstructor() {
    Fraction fraction = new FractionImpl(3, 4);
    assertEquals(3, fraction.getNumerator());
    assertEquals(4, fraction.getDenominator());

    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
  }

  @Test
  void testSetDenominator() {
    Fraction fraction = new FractionImpl(1, 2);
    fraction.setDenominator(3);
    assertEquals(3, fraction.getDenominator());

    assertThrows(IllegalArgumentException.class, () -> fraction.setDenominator(0));
  }

  @Test
  void testToDouble() {
    Fraction fraction = new FractionImpl(1, 2);
    assertEquals(0.5, fraction.toDouble());
  }

  @Test
  void testReciprocal() {
    Fraction fraction = new FractionImpl(3, 4);
    Fraction reciprocal = fraction.reciprocal();
    assertEquals(4, reciprocal.getNumerator());
    assertEquals(3, reciprocal.getDenominator());

    Fraction zeroFraction = new FractionImpl(0, 1);
    assertThrows(ArithmeticException.class, zeroFraction::reciprocal);
  }

  @Test
  void testAdd() {
    Fraction fraction1 = new FractionImpl(1, 2);
    Fraction fraction2 = new FractionImpl(1, 3);
    Fraction result = fraction1.add(fraction2);
    assertEquals(5, result.getNumerator());
    assertEquals(6, result.getDenominator());
  }

  @Test
  void testCompareTo() {
    Fraction fraction1 = new FractionImpl(1, 2);
    Fraction fraction2 = new FractionImpl(1, 3);
    assertTrue(fraction1.compareTo(fraction2) > 0);

    Fraction fraction3 = new FractionImpl(1, 2);
    assertEquals(0, fraction1.compareTo(fraction3));
  }

  @Test
  void testToString() {
    Fraction fraction = new FractionImpl(3, 4);
    assertEquals("3 / 4", fraction.toString());
  }
}