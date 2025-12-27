import java.util.Scanner;
class SmallestCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();

        boolean isSmallest = (n1 <= n2 && n1 <= n3);
        System.out.println("Is the first number the smallest? " + isSmallest);
    }
}
