import java.util.Scanner;

public class VolumeOfACylinder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int radiusCylinder=sc.nextInt();
        float height=sc.nextFloat();
        double areaCylinder= 3.14*(radiusCylinder*radiusCylinder)*height;
        System.out.println(areaCylinder);
    }
}
