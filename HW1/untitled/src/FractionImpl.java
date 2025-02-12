/**
 * FractionImpl is a concrete implementation of the Fraction interface.
 * It represents a fraction with an integer numerator and a positive integer denominator.
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a FractionImpl with the given numerator and denominator.
   * The fraction is normalized so that the denominator is positive.
   * @param numerator the numerator
   * @param denominator the denominator (must be positive)
   * @throws IllegalArgumentException if the denominator is not positive
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    normalize();
  }

  /**
   * Normalizes the fraction so that the denominator is positive.
   */
  private void normalize() {
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
    int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
    numerator /= gcd;
    denominator /= gcd;
  }

  /**
   * Computes the greatest common divisor of two integers.
   * @param a the first integer
   * @param b the second integer
   * @return the greatest common divisor of a and b
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public void setNumerator(int numerator) {
    this.numerator = numerator;
    normalize();
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.denominator = denominator;
    normalize();
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Cannot compute reciprocal of zero.");
    }
    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    int commonDenominator = this.denominator * other.getDenominator();
    int newNumerator = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
    return new FractionImpl(newNumerator, commonDenominator);
  }

  @Override
  public int compareTo(Fraction other) {
    int crossProduct1 = this.numerator * other.getDenominator();
    int crossProduct2 = other.getNumerator() * this.denominator;
    return crossProduct1 - crossProduct2;
  }

  @Override
  public String toString() {
    return numerator + " / " + denominator;
  }
}