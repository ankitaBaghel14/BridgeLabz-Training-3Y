import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CharFrequencyNestedLoop {

    /**
     * Finds the frequency of each character in a string using nested loops.
     *
     * @param text The input string.
     * @return A 2D array of strings with character and frequency pairs.
     */
    public static String[][] getCharacterFrequencies(String text) {
        char[] charArray = text.toCharArray();
        int[] frequency = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                continue; // Skip characters that have already been counted
            }
            frequency[i] = 1;
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    frequency[i]++;
                    charArray[j] = '0'; // Mark as counted
                }
            }
        }

        List<String[]> resultList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                String[] pair = {String.valueOf(charArray[i]), String.valueOf(frequency[i])};
                resultList.add(pair);
            }
        }
        return resultList.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getCharacterFrequencies(text);

        System.out.println("\n--- Character Frequencies (Nested Loops) ---");
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("--------------------");

        for (String[] pair : frequencies) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }
        input.close();
    }
}