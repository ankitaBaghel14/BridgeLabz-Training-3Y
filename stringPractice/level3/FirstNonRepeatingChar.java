import java.util.Scanner;

public class FirstNonRepeatingChar {

    /**
     * Finds the first non-repeating character in a string.
     *
     * @param text The input string.
     * @return The first non-repeating character, or '\0' if none is found.
     */
    public static char findFirstNonRepeating(String text) {
        // ASCII has 256 characters
        int[] frequency = new int[256];

        // Loop to find the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Loop through the text again to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return null character if no non-repeating char is found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char firstNonRepeating = findFirstNonRepeating(text);

        System.out.println("\n--- First Non-Repeating Character ---");
        System.out.println("Original String: \"" + text + "\"");
        if (firstNonRepeating != '\0') {
            System.out.println("The first non-repeating character is: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }

        input.close();
    }
}