import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OTPGenerator {

    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public static boolean areOTPsUnique(String[] otps) {
        Set<String> uniqueOTPs = new HashSet<>();
        for (String otp : otps) {
            uniqueOTPs.add(otp);
        }
        return uniqueOTPs.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] generatedOTPs = new String[10];

        System.out.println("Generating 10 OTPs...");
        for (int i = 0; i < 10; i++) {
            generatedOTPs[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + generatedOTPs[i]);
        }

        System.out.println("\nChecking for uniqueness...");
        if (areOTPsUnique(generatedOTPs)) {
            System.out.println("All 10 OTPs are unique.");
        } else {
            System.out.println("The generated OTPs are not unique.");
        }
    }
}