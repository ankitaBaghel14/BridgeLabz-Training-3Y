import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("25 175\n28 180\n22 170"); // Custom input

        System.out.println("Enter Amar's age and height (cm):");
        int amarAge = scanner.nextInt();
        int amarHeight = scanner.nextInt();

        System.out.println("Enter Akbar's age and height (cm):");
        int akbarAge = scanner.nextInt();
        int akbarHeight = scanner.nextInt();
        
        System.out.println("Enter Anthony's age and height (cm):");
        int anthonyAge = scanner.nextInt();
        int anthonyHeight = scanner.nextInt();

        String youngest = "Amar";
        int minAge = amarAge;
        if (akbarAge < minAge) {
            minAge = akbarAge;
            youngest = "Akbar";
        }
        if (anthonyAge < minAge) {
            youngest = "Anthony";
        }
        System.out.println("The youngest friend is " + youngest + ".");

        String tallest = "Amar";
        int maxHeight = amarHeight;
        if (akbarHeight > maxHeight) {
            maxHeight = akbarHeight;
            tallest = "Akbar";
        }
        if (anthonyHeight > maxHeight) {
            tallest = "Anthony";
        }
        System.out.println("The tallest friend is " + tallest + ".");

        scanner.close();
    }
}
