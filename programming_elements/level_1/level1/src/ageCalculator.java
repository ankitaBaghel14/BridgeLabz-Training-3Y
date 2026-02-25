import java.util.Scanner;
public class ageCalculator {
    public static void main(String[] args) {


                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter birth year: ");
                int birthYear = scanner.nextInt();

                System.out.print("Enter current year: ");
                int currentYear = scanner.nextInt();


                int age = currentYear - birthYear;


                System.out.println("Harry's age in " + currentYear + " is " + age);

                scanner.close();
            }
        }
