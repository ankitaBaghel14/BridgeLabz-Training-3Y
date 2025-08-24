import java.util.Scanner;

public class CustomStringTrim {

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
     * Determines the start and end indices of the non-space characters in a string.
     * @param text The input string.
     * @return An int array [startIndex, endIndex].
     */
    public static int[] getTrimmedIndices(String text) {
        int length = getStringLengthWithoutBuiltIn(text);
        if (length == 0) {
            return new int[]{0, 0};
        }

        int startIndex = 0;
        while (startIndex < length && text.charAt(startIndex) == ' ') {
            startIndex++;
        }

        int endIndex = length - 1;
        while (endIndex >= startIndex && text.charAt(endIndex) == ' ') {
            endIndex--;
        }

        // endIndex is exclusive for substring, so we use endIndex + 1 for substring method
        return new int[]{startIndex, endIndex + 1};
    }

    /**
     * Creates a substring from a string using charAt() given start and end indices.
     * (Adapted from Level 1 example)
     * @param text The main string.
     * @param startIndex The inclusive starting index.
     * @param endIndex The exclusive ending index.
     * @return The substring.
     */
    public static String customSubstring(String text, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > getStringLengthWithoutBuiltIn(text) || startIndex > endIndex) {
            // Handle invalid indices gracefully, e.g., return empty string or throw error
            // For this context, we will return an empty string for simplicity.
            return "";
        }
        StringBuilder sub = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            sub.append(text.charAt(i));
        }
        return sub.toString();
    }

    /**
     * Compares two strings using charAt().
     * (Reused from Level 1 example)
     * @param s1 The first string.
     * @param s2 The second string.
     * @return true if strings are equal, false otherwise.
     */
    public static boolean compareStrings(String s1, String s2) {
        if (getStringLengthWithoutBuiltIn(s1) != getStringLengthWithoutBuiltIn(s2)) {
            return false;
        }
        for (int i = 0; i < getStringLengthWithoutBuiltIn(s1); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string with leading/trailing spaces: ");
        String originalText = input.nextLine();

        // Custom trim logic
        int[] indices = getTrimmedIndices(originalText);
        String customTrimmed = customSubstring(originalText, indices[0], indices[1]);
        System.out.println("Original:    \"" + originalText + "\"");
        System.out.println("Custom Trim: \"" + customTrimmed + "\"");

        // Built-in trim() method
        String builtInTrimmed = originalText.trim();
        System.out.println("Built-in Trim: \"" + builtInTrimmed + "\"");

        // Compare the results
        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Are the custom and built-in trimmed strings equal? " + areEqual);

        input.close();
    }
}