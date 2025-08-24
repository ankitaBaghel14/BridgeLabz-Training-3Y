import java.util.Scanner;

public class VowelConsonantCounter {

    /**
     * Checks if a character is a vowel, consonant, or not a letter.
     * Converts to lowercase for consistent checking.
     * @param c The character to check.
     * @return "Vowel", "Consonant", or "Not a Letter".
     */
    public static String getCharType(char c) {
        // Convert to lowercase to simplify checking
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32); // ASCII difference for uppercase to lowercase
        }

        if (c >= 'a' && c <= 'z') { // Check if it's an alphabet
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
     * Finds vowels and consonants in a string and returns their counts in an array.
     * @param text The input string.
     * @return An int array where result[0] is vowel count, result[1] is consonant count.
     */
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String type = getCharType(c); // Use the helper method

            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("\n--- Vowel and Consonant Count ---");
        System.out.println("Original string: \"" + text + "\"");
        System.out.println("Vowel Count: " + counts[0]);
        System.out.println("Consonant Count: " + counts[1]);

        input.close();
    }
}