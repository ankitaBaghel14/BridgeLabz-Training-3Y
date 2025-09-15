import java.util.Arrays;

public class NumberChecker3 {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int number) {
        int[] originalDigits = storeDigits(number);
        int[] reversedDigits = reverseDigitsArray(originalDigits);
        return areArraysEqual(originalDigits, reversedDigits);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 121;
        int[] digits = storeDigits(number);

        System.out.println("Is " + number + " a Palindrome? " + isPalindrome(number));
        System.out.println("Is " + number + " a Duck Number? " + isDuckNumber(digits));
    }
}