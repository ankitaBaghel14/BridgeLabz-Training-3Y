public class NumberChecker5 {

    public static int findSumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) return false;
        return findSumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return findSumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return findSumOfProperDivisors(number) < number;
    }

    public static long factorial(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        long sumOfFactorials = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sumOfFactorials += factorial(digit);
            temp /= 10;
        }
        return sumOfFactorials == originalNumber;
    }

    public static void main(String[] args) {
        int number = 28;
        System.out.println("Is " + number + " a Perfect number? " + isPerfectNumber(number));
        System.out.println("Is " + number + " an Abundant number? " + isAbundantNumber(number));
        System.out.println("Is " + number + " a Deficient number? " + isDeficientNumber(number));

        number = 145;
        System.out.println("Is " + number + " a Strong number? " + isStrongNumber(number));
    }
}