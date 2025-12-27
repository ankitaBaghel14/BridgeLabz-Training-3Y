import java.util.Scanner;

class HeightConversion {
    public static void main(String[] args) {

        double heightCm;
        double heightInches;
        int heightFeet;
        double remainingInches;
        final double CM_TO_INCH = 2.54;
        final int INCHES_IN_FOOT = 12;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in cm: ");
        heightCm = input.nextDouble();

        heightInches = heightCm / CM_TO_INCH;
        heightFeet = (int) (heightInches / INCHES_IN_FOOT);
        remainingInches = heightInches % INCHES_IN_FOOT;

        System.out.println("Your Height in cm is " + heightCm +
                " while in feet is " + heightFeet +
                " and inches is " + remainingInches);

        input.close();
    }
}
