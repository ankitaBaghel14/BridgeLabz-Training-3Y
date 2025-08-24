import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException
    public static void generateIllegalArgumentException(String inputString) {
        System.out.println("Attempting to create substring with invalid arguments...");
        // This will cause an IllegalArgumentException
        String sub = inputString.substring(5, 2); // Start index > end index
        System.out.println("Substring: " + sub); // This line will not be reached
    }

    // Method to handle IllegalArgumentException
    public static void handleIllegalArgumentException(String inputString) {
        try {
            System.out.println("Attempting to create substring with invalid arguments with try-catch...");
            String sub = inputString.substring(5, 2); // Start index > end index
            System.out.println("Substring: " + sub); // This line will not be reached
        } catch (IllegalArgumentException e) {
            System.err.println("Caught IllegalArgumentException: " + e.getMessage());
            System.out.println("You provided illegal or inappropriate arguments to a method.");
        } catch (RuntimeException e) { // Generic catch for other unexpected runtime errors
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string (e.g., 'Hello World'): ");
        String text = input.nextLine();

        System.out.println("\n--- Demonstrating IllegalArgumentException Generation ---");
        // Call the method to generate the exception (will crash if not caught)
        // generateIllegalArgumentException(text); // Uncomment to see crash

        System.out.println("\n--- Demonstrating IllegalArgumentException Handling ---");
        // Call the method that handles the exception
        handleIllegalArgumentException(text);

        input.close();
    }
}