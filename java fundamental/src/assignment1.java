import java.util.Scanner;
public class assignment1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Write a program that prints "Welcome to Bridgelabz!" to the screen.
//
//
//
//        //Add Two Numbers
//        int a=sc.nextInt();
//        int b=sc.nextInt();
//        System.out.println("Addition of Two Numbers is "+ (a+b));

        //3. Celsius to Fahrenheit Conversion
//

        //4. Area of a Circle
//        int radius= sc.nextInt();
//        double area= 3.14 * (radius*radius);
//        System.out.println(area);
//
//        //Volume of a Cylinder
        int radiusCylinder=sc.nextInt();
        float height=sc.nextFloat();
        double areaCylinder= 3.14*(radiusCylinder*radiusCylinder)*height;
        System.out.println(areaCylinder);


        //Self Problems
//        1. Calculate Simple Interest
        float principal=sc.nextFloat();
        float rate=sc.nextFloat();
        float time=sc.nextFloat();
        double simpleInterest=(principal*rate*time)/100;


        sc.close();
    }
}
