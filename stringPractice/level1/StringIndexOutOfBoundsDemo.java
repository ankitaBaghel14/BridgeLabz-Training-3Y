import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateStringIndexOutOfBoundsException(String inputString) {
        System.out.println("Attempting to access character beyond string length...");
        // This will cause a StringIndexOutOfBoundsException if index is invalid
        char c = inputString.charAt(inputString.length()); // Accessing index equal to length
        System.out.println("Character at invalid index: " + c); // This line will not be reached
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleStringIndexOutOfBoundsException(String inputString) {
        try {
            System.out.println("Attempting to access character beyond string length with try-catch...");
            char c = inputString.charAt(inputString.length()); // Accessing index equal to length
            System.out.println("Character at invalid index: " + c); // This line will not be reached
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("You tried to access an index outside the valid range (0 to " + (inputString.length() - 1) + ").");
        } catch (RuntimeException e) { // Generic catch for other unexpected runtime errors
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException Generation ---");
        // Call the method to generate the exception (will crash if not caught)
        // Uncomment the line below to see the exception terminate the program
        // generateStringIndexOutOfBoundsException(text);

        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException Handling ---");
        // Call the method that handles the exception
        handleStringIndexOutOfBoundsException(text);

        input.close();
    }
}