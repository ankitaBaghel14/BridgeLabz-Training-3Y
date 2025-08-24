import java.util.Scanner;

public class StringComparison {

    // Method to compare two strings using charAt()
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

        System.out.print("Enter the first string: ");
        String str1 = input.nextLine(); // Use nextLine for strings with spaces

        System.out.print("Enter the second string: ");
        String str2 = input.nextLine();

        // Compare using user-defined method
        boolean customEqualsResult = compareStrings(str1, str2);
        System.out.println("Comparison using custom charAt() method: " + customEqualsResult);

        // Compare using built-in equals() method
        boolean builtInEqualsResult = str1.equals(str2);
        System.out.println("Comparison using built-in equals() method: " + builtInEqualsResult);

        // Check if results are the same
        if (customEqualsResult == builtInEqualsResult) {
            System.out.println("Both comparison methods yielded the same result.");
        } else {
            System.out.println("Comparison methods yielded different results.");
        }

        input.close();
    }
}