import java.util.Arrays;
import java.util.Scanner;

public class CharArrayComparison {

    // Method to return all characters in a string without using toCharArray()
    public static char[] getCharsCustom(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Get characters using user-defined method
        char[] customChars = getCharsCustom(text);
        System.out.println("Characters using custom method: " + Arrays.toString(customChars));

        // Get characters using built-in toCharArray() method
        char[] builtInChars = text.toCharArray();
        System.out.println("Characters using built-in toCharArray() method: " + Arrays.toString(builtInChars));

        // Compare the two arrays
        boolean areEqual = compareCharArrays(customChars, builtInChars);
        System.out.println("Are the two character arrays equal? " + areEqual);

        input.close();
    }
}