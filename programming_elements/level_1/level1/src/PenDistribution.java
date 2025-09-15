import java.util.Scanner;

class PenDistribution {
    public static void main(String[] args) {

        int totalPens;
        int students;
        int pensPerStudent;
        int remainingPens;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of pens: ");
        totalPens = input.nextInt();

        System.out.print("Enter number of students: ");
        students = input.nextInt();

        pensPerStudent = totalPens / students;
        remainingPens = totalPens % students;

        System.out.println("The Pen Per Student is " + pensPerStudent +
                " and the remaining pen not distributed is " + remainingPens);

        input.close();
    }
}
