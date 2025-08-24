import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacters {

    /**
     * Finds the length of a string without using the built-in length() method.
     *
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception, ignore
        }
        return count;
    }

    /**
     * Finds unique characters in a string using nested loops.
     *
     * @param text The input string.
     * @return A char array containing only the unique characters.
     */
    public static char[] findUniqueCharacters(String text) {
        int length = getStringLength(text);
        char[] tempUnique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempUnique[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }
        // Create a new array with the exact size of unique characters
        return Arrays.copyOf(tempUnique, uniqueCount);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("\n--- Unique Characters ---");
        System.out.println("Original String: \"" + text + "\"");
        System.out.println("Unique Characters: " + Arrays.toString(uniqueChars));

        input.close();
    }
}