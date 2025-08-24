import java.util.Scanner;

public class UppercaseConverter {

    // Method to convert a string to uppercase using charAt()
    public static String toUpperCaseCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // Convert lowercase to uppercase using ASCII difference
                result.append((char) (c - 32));
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

        System.out.print("Enter a string to convert to uppercase: ");
        String originalText = input.nextLine();

        // Convert using user-defined method
        String customUppercase = toUpperCaseCustom(originalText);
        System.out.println("Custom uppercase: " + customUppercase);

        // Convert using built-in toUpperCase() method
        String builtInUppercase = originalText.toUpperCase();
        System.out.println("Built-in uppercase: " + builtInUppercase);

        // Compare the two results
        boolean areEqual = compareStrings(customUppercase, builtInUppercase);
        System.out.println("Are the custom and built-in uppercase strings equal? " + areEqual);

        input.close();
    }
}