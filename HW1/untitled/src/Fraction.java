/**
 * The Fraction interface specifies the protocol for a fraction with an integer numerator
 * and a positive integer denominator. It includes methods for basic arithmetic operations,
 * comparison, and conversion to a double.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Returns the numerator of the fraction.
   * @return the numerator
   */
  int getNumerator();

  /**
   * Sets the numerator of the fraction.
   * @param numerator the new numerator
   */
  void setNumerator(int numerator);

  /**
   * Returns the denominator of the fraction.
   * @return the denominator
   */
  int getDenominator();

  /**
   * Sets the denominator of the fraction. The denominator must be positive.
   * @param denominator the new denominator
   * @throws IllegalArgumentException if the denominator is not positive
   */
  void setDenominator(int denominator);

  /**
   * Returns the decimal value of the fraction.
   * @return the decimal value of the fraction
   */
  double toDouble();

  /**
   * Returns the reciprocal of the fraction.
   * @return the reciprocal of the fraction
   * @throws ArithmeticException if the numerator is zero
   */
  Fraction reciprocal();

  /**
   * Adds another fraction to this fraction and returns the result.
   * @param other the fraction to add
   * @return the sum of the two fractions
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to another fraction.
   * @param other the fraction to compare to
   * @return a negative integer, zero, or a positive integer if this fraction is less than,
   *         equal to, or greater than the specified fraction
   */
  @Override
  int compareTo(Fraction other);
}