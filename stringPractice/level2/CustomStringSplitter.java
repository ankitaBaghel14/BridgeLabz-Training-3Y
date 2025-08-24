import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomStringSplitter {

    /**
     * Finds the length of a string without using the built-in length() method.
     * (Reused from previous example)
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLengthWithoutBuiltIn(String text) {
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
     * Splits a string into words using charAt() without the built-in split() method.
     * @param text The input string.
     * @return An array of words.
     */
    public static String[] splitTextIntoWordsCustom(String text) {
        List<String> wordsList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        // Trim leading and trailing spaces for accurate word counting
        text = text.trim();
        if (getStringLengthWithoutBuiltIn(text) == 0) {
            return new String[0]; // Return empty array if string is empty or just spaces
        }

        for (int i = 0; i < getStringLengthWithoutBuiltIn(text); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (getStringLengthWithoutBuiltIn(currentWord.toString()) > 0) { // Add word if not empty
                    wordsList.add(currentWord.toString());
                    currentWord = new StringBuilder(); // Reset for next word
                }
            } else {
                currentWord.append(c);
            }
        }
        // Add the last word if it exists
        if (getStringLengthWithoutBuiltIn(currentWord.toString()) > 0) {
            wordsList.add(currentWord.toString());
        }

        return wordsList.toArray(new String[0]);
    }

    /**
     * Compares two String arrays for equality.
     * @param arr1 The first array.
     * @param arr2 The second array.
     * @return true if arrays are equal, false otherwise.
     */
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) { // Use .equals() for string comparison
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        // Using user-defined method to split
        String[] customWords = splitTextIntoWordsCustom(sentence);
        System.out.println("Words using custom method: " + Arrays.toString(customWords));

        // Using built-in split() method
        String[] builtInWords = sentence.trim().split("\\s+"); // Split by one or more spaces
        System.out.println("Words using built-in split() method: " + Arrays.toString(builtInWords));

        // Compare the two arrays of words
        boolean areEqual = compareStringArrays(customWords, builtInWords);
        System.out.println("Are the two arrays of words equal? " + areEqual);

        input.close();
    }
}