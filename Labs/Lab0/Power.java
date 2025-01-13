public class Power {
    public static void main(String[] args) {
        long result = (long) Math.pow(2, 31); // 2 raised to the power of 31
        System.out.println(result);
    }
}
// the first different is in Java you explicitly use the Math.pow() method and in Python you use ** for exponentiation
// the result of Math.pow() is a floating-point number, while the result of 2 ** 31 is an int
// in java, you need to use BigInteger for numbers larger than long type, in Python you don't
// To print the result in Java, you use System.out.println() or System.out.print(), while Python uses the print() function to output the result.
// In java, you need to define the type of the result explicitly, either as int, long, or double, and handle type casting when necessary; while in Python, Variables in Python are dynamically typed, so the result is automatically assigned the correct type without any need for explicit casting.