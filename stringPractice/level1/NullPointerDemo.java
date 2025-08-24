import java.util.Scanner;

public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateNullPointerException() {
        String text = null;
        System.out.println("Attempting to get length of null string...");
        // This line will cause a NullPointerException
        int length = text.length();
        System.out.println("Length: " + length); // This line will not be reached
    }

    // Method to handle NullPointerException
    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println("Attempting to get length of null string with try-catch...");
            int length = text.length(); // This might throw NullPointerException
            System.out.println("Length: " + length); // This line will not be reached if exception occurs
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
            System.out.println("The string variable 'text' was null.");
        } catch (RuntimeException e) { // Generic catch for other unexpected runtime errors
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating NullPointerException Generation ---");
        // Call the method to generate the exception (will crash if not caught)
        // Uncomment the line below to see the exception terminate the program
        // generateNullPointerException();

        System.out.println("\n--- Demonstrating NullPointerException Handling ---");
        // Refactor to call the method that handles the exception
        handleNullPointerException();
    }
}