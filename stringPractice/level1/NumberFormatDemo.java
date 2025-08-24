import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateNumberFormatException(String textInput) {
        System.out.println("Attempting to parse non-numeric string to integer...");
        // This will cause a NumberFormatException
        int number = Integer.parseInt(textInput);
        System.out.println("Parsed number: " + number); // This line will not be reached
    }

    // Method to handle NumberFormatException
    public static void handleNumberFormatException(String textInput) {
        try {
            System.out.println("Attempting to parse non-numeric string to integer with try-catch...");
            int number = Integer.parseInt(textInput);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.err.println("Caught NumberFormatException: " + e.getMessage());
            System.out.println("The input string '" + textInput + "' could not be converted to an integer.");
        } catch (RuntimeException e) { // Generic catch for other unexpected runtime errors
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string that you expect to be a number (e.g., '123' or 'abc'): ");
        String text = input.nextLine();

        System.out.println("\n--- Demonstrating NumberFormatException Generation ---");
        // Call the method to generate the exception (will crash if not caught)
        // generateNumberFormatException(text); // Uncomment to see crash

        System.out.println("\n--- Demonstrating NumberFormatException Handling ---");
        // Call the method that handles the exception
        handleNumberFormatException(text);

        input.close();
    }
}