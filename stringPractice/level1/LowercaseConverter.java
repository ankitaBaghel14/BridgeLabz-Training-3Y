import java.util.Scanner;

public class LowercaseConverter {

    // Method to convert a string to lowercase using charAt()
    public static String toLowerCaseCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                // Convert uppercase to lowercase using ASCII difference
                result.append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to compare two strings using charAt() (reused)
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

        System.out.print("Enter a string to convert to lowercase: ");
        String originalText = input.nextLine();

        // Convert using user-defined method
        String customLowercase = toLowerCaseCustom(originalText);
        System.out.println("Custom lowercase: " + customLowercase);

        // Convert using built-in toLowerCase() method
        String builtInLowercase = originalText.toLowerCase();
        System.out.println("Built-in lowercase: " + builtInLowercase);

        // Compare the two results
        boolean areEqual = compareStrings(customLowercase, builtInLowercase);
        System.out.println("Are the custom and built-in lowercase strings equal? " + areEqual);

        input.close();
    }
}