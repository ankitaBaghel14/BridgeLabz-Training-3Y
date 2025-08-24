import java.util.Scanner;

public class SubstringCreator {

    // Method to create a substring using charAt()
    public static String customSubstring(String text, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > text.length() || startIndex > endIndex) {
            System.err.println("Invalid start or end index for custom substring.");
            return ""; // Return empty string for invalid indices
        }
        StringBuilder sub = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            sub.append(text.charAt(i));
        }
        return sub.toString();
    }

    // Method to compare two strings using charAt() (reused from previous example)
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String mainString = input.nextLine();

        System.out.print("Enter start index for substring: ");
        int startIndex = input.nextInt();

        System.out.print("Enter end index (exclusive) for substring: ");
        int endIndex = input.nextInt();

        // Create substring using user-defined method
        String customSub = customSubstring(mainString, startIndex, endIndex);
        System.out.println("Substring using custom charAt() method: \"" + customSub + "\"");

        // Create substring using built-in substring() method
        String builtInSub;
        try {
            builtInSub = mainString.substring(startIndex, endIndex);
        } catch (StringIndexOutOfBoundsException e) {
            builtInSub = "Error: " + e.getMessage();
            System.err.println("Built-in substring error: " + e.getMessage());
        }
        System.out.println("Substring using built-in substring() method: \"" + builtInSub + "\"");

        // Compare the two substrings (if both were successfully generated)
        if (!customSub.isEmpty() && !builtInSub.startsWith("Error")) {
            boolean areEqual = compareStrings(customSub, builtInSub);
            System.out.println("Are the two substrings equal? " + areEqual);
        } else {
            System.out.println("Cannot compare substrings due to an error in generation.");
        }

        input.close();
    }
}