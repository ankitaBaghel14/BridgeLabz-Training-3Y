import java.util.Scanner;

public class StringLengthWithoutBuiltIn {

    /**
     * Finds the length of a string without using the built-in length() method.
     * It counts characters by iterating with charAt() until an exception occurs.
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLengthWithoutBuiltIn(String text) {
        int count = 0;
        try {
            while (true) { // Infinite loop to count characters
                text.charAt(count); // Access character at current count
                count++;            // Increment count if successful
            }
        } catch (StringIndexOutOfBoundsException e) {
            // This exception indicates we've gone past the end of the string.
            // The 'count' at this point is the actual length.
            // No need to print error, it's expected behavior for this logic.
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Using user-defined method
        int customLength = getStringLengthWithoutBuiltIn(text);
        System.out.println("Length using custom method: " + customLength);

        // Using built-in length() method
        int builtInLength = text.length();
        System.out.println("Length using built-in length() method: " + builtInLength);

        // Compare results
        if (customLength == builtInLength) {
            System.out.println("Both methods returned the same length.");
        } else {
            System.out.println("Lengths from custom and built-in methods differ.");
        }

        input.close();
    }
}