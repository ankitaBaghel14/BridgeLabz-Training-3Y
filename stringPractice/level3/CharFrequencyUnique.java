import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CharFrequencyUnique {

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
        return Arrays.copyOf(tempUnique, uniqueCount);
    }

    /**
     * Finds the frequency of unique characters in a string.
     *
     * @param text The input string.
     * @return A 2D array with unique characters and their frequencies.
     */
    public static String[][] getUniqueCharFrequencies(String text) {
        char[] uniqueChars = findUniqueCharacters(text);
        String[][] frequencies = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char uniqueChar = uniqueChars[i];
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == uniqueChar) {
                    count++;
                }
            }
            frequencies[i][0] = String.valueOf(uniqueChar);
            frequencies[i][1] = String.valueOf(count);
        }

        return frequencies;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] uniqueFrequencies = getUniqueCharFrequencies(text);

        System.out.println("\n--- Unique Character Frequencies ---");
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("--------------------");

        for (String[] pair : uniqueFrequencies) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }
        input.close();
    }
}