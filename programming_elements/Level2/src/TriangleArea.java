import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking input
        System.out.print("Enter base (cm): ");
        double base = input.nextDouble();

        System.out.print("Enter height (cm): ");
        double height = input.nextDouble();

        // Calculations
        double areaCmSq = 0.5 * base * height;
        double cmToInch = 2.54;
        double areaInchSq = areaCmSq / (cmToInch * cmToInch);

        // Output
        System.out.println("The Area of the triangle in sq in is " + areaInchSq + " and sq cm is " + areaCmSq);

        input.close();
    }
}
