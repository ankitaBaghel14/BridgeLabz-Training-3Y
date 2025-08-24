import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShortestLongestWord {

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
     * (Reused from previous example)
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
     * Finds the shortest and longest strings from a 2D array of words and their lengths.
     * @param wordsAndLengths A 2D String array [[word, length_as_string], ...].
     * @return A 1D String array: [shortestWord, longestWord].
     */
    public static String[] findShortestAndLongest(String[][] wordsAndLengths) {
        if (wordsAndLengths == null || wordsAndLengths.length == 0) {
            return new String[]{"", ""}; // Return empty strings if no words
        }

        String shortestWord = wordsAndLengths[0][0];
        int shortestLength = Integer.parseInt(wordsAndLengths[0][1]);
        String longestWord = wordsAndLengths[0][0];
        int longestLength = Integer.parseInt(wordsAndLengths[0][1]);

        for (int i = 1; i < wordsAndLengths.length; i++) {
            String currentWord = wordsAndLengths[i][0];
            int currentLength = Integer.parseInt(wordsAndLengths[i][1]);

            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestWord = currentWord;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestWord = currentWord;
            }
        }
        return new String[]{shortestWord, longestWord};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String[] words = splitTextIntoWordsCustom(sentence);
        if (words.length == 0) {
            System.out.println("No words found in the sentence.");
            return;
        }

        String[][] wordsWithLengths = getWordsAndLengths(words);
        String[] shortestAndLongest = findShortestAndLongest(wordsWithLengths);

        System.out.println("\n--- Shortest and Longest Word ---");
        System.out.println("Shortest word: \"" + shortestAndLongest[0] + "\" (Length: " + getStringLengthWithoutBuiltIn(shortestAndLongest[0]) + ")");
        System.out.println("Longest word: \"" + shortestAndLongest[1] + "\" (Length: " + getStringLengthWithoutBuiltIn(shortestAndLongest[1]) + ")");

        input.close();
    }
}