import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateArrayIndexOutOfBoundsException(String[] namesArray) {
        System.out.println("Attempting to access array element beyond its bounds...");
        // This will cause an ArrayIndexOutOfBoundsException
        String name = namesArray[namesArray.length]; // Accessing index equal to length
        System.out.println("Name at invalid index: " + name); // This line will not be reached
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleArrayIndexOutOfBoundsException(String[] namesArray) {
        try {
            System.out.println("Attempting to access array element beyond its bounds with try-catch...");
            String name = namesArray[namesArray.length]; // Accessing index equal to length
            System.out.println("Name at invalid index: " + name); // This line will not be reached
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("You tried to access an array element at an invalid index (valid range: 0 to " + (namesArray.length - 1) + ").");
        } catch (RuntimeException e) { // Generic catch for other unexpected runtime errors
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of names to store: ");
        int size = input.nextInt();
        input.nextLine(); // Consume newline

        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.nextLine();
        }

        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException Generation ---");
        // Call the method to generate the exception (will crash if not caught)
        // generateArrayIndexOutOfBoundsException(names); // Uncomment to see crash

        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException Handling ---");
        // Call the method that handles the exception
        handleArrayIndexOutOfBoundsException(names);

        input.close();
    }
}