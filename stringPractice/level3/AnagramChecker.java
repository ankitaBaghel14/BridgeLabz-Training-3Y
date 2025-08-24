import java.util.Scanner;

public class AnagramChecker {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param text1 The first string.
     * @param text2 The second string.
     * @return True if the strings are anagrams, false otherwise.
     */
    public static boolean areAnagrams(String text1, String text2) {
        // Clean and normalize strings
        String s1 = text1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s2 = text2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if lengths are equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Use ASCII array to count character frequencies
        int[] frequency = new int[256];

        // Increment frequency for s1
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i)]++;
        }

        // Decrement frequency for s2
        for (int i = 0; i < s2.length(); i++) {
            frequency[s2.charAt(i)]--;
        }

        // Check if all frequencies are zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String text1 = input.nextLine();
        System.out.print("Enter the second string: ");
        String text2 = input.nextLine();

        boolean result = areAnagrams(text1, text2);

        System.out.println("\n--- Anagram Check ---");
        System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are " + (result ? "anagrams." : "not anagrams."));

        input.close();
    }
}