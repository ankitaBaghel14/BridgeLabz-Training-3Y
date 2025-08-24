import java.util.Scanner;
import java.util.Arrays;

public class PalindromeChecker {

    // --- Logic 1: Iterative Comparison ---
    public static boolean isPalindromeIterative(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = cleanedText.length() - 1;
        while (start < end) {
            if (cleanedText.charAt(start) != cleanedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // --- Logic 2: Recursive Comparison ---
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // --- Logic 3: Reverse and Compare Arrays ---
    public static char[] reverseString(String text) {
        char[] reversedArray = new char[text.length()];
        int j = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedArray[j++] = text.charAt(i);
        }
        return reversedArray;
    }

    public static boolean isPalindromeArray(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] originalArray = cleanedText.toCharArray();
        char[] reversedArray = reverseString(cleanedText);
        return Arrays.equals(originalArray, reversedArray);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text to check if it's a palindrome: ");
        String text = input.nextLine();

        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Original Text: \"" + text + "\"");

        // Check using Logic 1
        boolean result1 = isPalindromeIterative(text);
        System.out.println("Result (Iterative): " + (result1 ? "Is a Palindrome" : "Is not a Palindrome"));

        // Check using Logic 2
        String cleanedForRecursive = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean result2 = isPalindromeRecursive(cleanedForRecursive, 0, cleanedForRecursive.length() - 1);
        System.out.println("Result (Recursive): " + (result2 ? "Is a Palindrome" : "Is not a Palindrome"));

        // Check using Logic 3
        boolean result3 = isPalindromeArray(text);
        System.out.println("Result (Array Comparison): " + (result3 ? "Is a Palindrome" : "Is not a Palindrome"));

        input.close();
    }
}