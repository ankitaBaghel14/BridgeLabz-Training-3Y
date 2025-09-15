import java.util.Random;

public class RandomNumberStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000); // Generates a random number between 1000 and 9999
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double[] results = new double[3]; // [0] = average, [1] = min, [2] = max
        if (numbers.length == 0) {
            return results;
        }

        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        results[0] = sum / numbers.length;
        results[1] = min;
        results[2] = max;
        return results;
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);

        System.out.print("Generated random numbers: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + (i == randomNumbers.length - 1 ? "" : ", "));
        }
        System.out.println();

        double[] stats = findAverageMinMax(randomNumbers);

        System.out.printf("Average value: %.2f\n", stats[0]);
        System.out.printf("Minimum value: %.0f\n", stats[1]);
        System.out.printf("Maximum value: %.0f\n", stats[2]);
    }
}