import java.util.Scanner;

public class CharTypeDisplay {

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
     * Checks if a character is a vowel, consonant, or not a letter.
     * Converts to lowercase for consistent checking.
     * (Reused from previous example)
     * @param c The character to check.
     * @return "Vowel", "Consonant", or "Not a Letter".
     */
    public static String getCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32); // ASCII difference for uppercase to lowercase
        }

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    /**
     * Finds vowels and consonants in a string and returns a 2D array
     * with each character and its type.
     * @param text The input string.
     * @return A 2D String array [[character_as_string, type], ...].
     */
    public static String[][] getCharTypesArray(String text) {
        String[][] charTypes = new String[getStringLengthWithoutBuiltIn(text)][2];
        for (int i = 0; i < getStringLengthWithoutBuiltIn(text); i++) {
            char c = text.charAt(i);
            charTypes[i][0] = String.valueOf(c);
            charTypes[i][1] = getCharType(c);
        }
        return charTypes;
    }

    /**
     * Displays a 2D array of Strings in a tabular format.
     * (Reused and adapted from previous example)
     * @param data The 2D array to display.
     * @param headers An array of column headers.
     */
    public static void display2DStringArrayTabular(String[][] data, String[] headers) {
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

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] charTypes = getCharTypesArray(text);

        System.out.println("\n--- Character Types ---");
        String[] headers = {"Character", "Type"};
        display2DStringArrayTabular(charTypes, headers);

        input.close();
    }
}