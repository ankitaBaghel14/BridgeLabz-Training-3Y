import java.util.Scanner;

public class perimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float length= sc.nextFloat();
        float width= sc.nextFloat();
        double perimeter=2*(length + width);
        sc.close();
    }
}
