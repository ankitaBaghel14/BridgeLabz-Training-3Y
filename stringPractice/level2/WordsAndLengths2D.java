import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordsAndLengths2D {

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
     * (Reused from previous example)
     * @param text The input string.
     * @return An array of words.
     */
    public static String[] splitTextIntoWordsCustom(String text) {
        List<String> wordsList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        text = text.trim();
        if (getStringLengthWithoutBuiltIn(text) == 0) {
            return new String[0];
        }

        for (int i = 0; i < getStringLengthWithoutBuiltIn(text); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (getStringLengthWithoutBuiltIn(currentWord.toString()) > 0) {
                    wordsList.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            } else {
                currentWord.append(c);
            }
        }
        if (getStringLengthWithoutBuiltIn(currentWord.toString()) > 0) {
            wordsList.add(currentWord.toString());
        }

        return wordsList.toArray(new String[0]);
    }

    /**
     * Takes an array of words and returns a 2D String array where each row
     * contains the word and its corresponding length as a String.
     * @param words An array of words.
     * @return A 2D String array [[word, length_as_string], ...].
     */
    public static String[][] getWordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLengthWithoutBuiltIn(words[i]));
        }
        return result;
    }

    /**
     * Displays a 2D array of Strings in a tabular format.
     * @param data The 2D array to display.
     * @param headers An array of column headers.
     */
    public static void display2DArrayTabular(String[][] data, String[] headers) {
        // Calculate max column widths for formatting
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = getStringLengthWithoutBuiltIn(headers[i]);
        }
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                if (getStringLengthWithoutBuiltIn(row[j]) > colWidths[j]) {
                    colWidths[j] = getStringLengthWithoutBuiltIn(row[j]);
                }
            }
        }

        // Print headers
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("%-" + (colWidths[i] + 2) + "s", headers[i]);
        }
        System.out.println();
        // Print separator
        for (int i = 0; i < headers.length; i++) {
            for (int j = 0; j < colWidths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println();

        // Print data
        for (String[] row : data) {
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%-" + (colWidths[j] + 2) + "s", row[j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String[] words = splitTextIntoWordsCustom(sentence);
        String[][] wordsWithLengths = getWordsAndLengths(words);

        System.out.println("\n--- Words and their Lengths ---");
        String[] headers = {"Word", "Length"};
        display2DArrayTabular(wordsWithLengths, headers);

        input.close();
    }
}