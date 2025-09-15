public class SpringSeason {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide month and day as command-line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    public static boolean isSpringSeason(int month, int day) {
        if (month < 3 || month > 6) {
            return false;
        }
        if (month == 3) {
            return day >= 20;
        }
        if (month == 6) {
            return day <= 20;
        }
        return true;
    }
}