import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharFrequency {

    /**
     * Finds the frequency of all characters in a string.
     *
     * @param text The input string.
     * @return A 2D array with characters and their frequencies.
     */
    public static String[][] getCharacterFrequencies(String text) {
        int[] frequency = new int[256];

        // Loop to find the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Store non-zero frequencies in a list of arrays
        List<String[]> resultList = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                String[] pair = new String[2];
                pair[0] = String.valueOf((char) i);
                pair[1] = String.valueOf(frequency[i]);
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

        System.out.println("\n--- Character Frequencies ---");
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("--------------------");

        for (String[] pair : frequencies) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }
        input.close();
    }
}