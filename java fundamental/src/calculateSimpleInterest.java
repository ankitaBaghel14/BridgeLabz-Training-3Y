import java.util.Scanner;

public class calculateSimpleInterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float principal=sc.nextFloat();
        float rate=sc.nextFloat();
        float time=sc.nextFloat();
        double simpleInterest=(principal*rate*time)/100;
    }
}
