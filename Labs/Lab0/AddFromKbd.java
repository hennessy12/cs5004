import java.util.Scanner; // Import the Scanner class

public class AddFromKbd {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first integer
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt(); // Read the first integer

        // Prompt the user to enter the second integer
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt(); // Read the second integer

        // Calculate the sum of the two integers
        int sum = num1 + num2;

        // Print the sum
        System.out.println("The sum is: " + sum);

        // Close the scanner
        scanner.close();
    }
}
