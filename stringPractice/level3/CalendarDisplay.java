import java.util.Scanner;

public class CalendarDisplay {

    /**
     * Method to get the name of the month.
     * @param month The month number (1-12).
     * @return The name of the month.
     */
    public static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return monthNames[month];
        }
        return "Invalid Month";
    }

    /**
     * Checks if a year is a leap year.
     * @param year The year to check.
     * @return True if it's a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Gets the number of days in a given month and year.
     * @param month The month number (1-12).
     * @param year The year.
     * @return The number of days.
     */
    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    /**
     * Gets the first day of the month using the Gregorian calendar algorithm.
     * @param year The year.
     * @param month The month (1-12).
     * @return The day of the week (0=Sunday, 1=Monday, ..., 6=Saturday).
     */
    public static int getFirstDayOfMonth(int year, int month) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7; // d is 1 for the first day of the month
        return d0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();

        // Validate month and year
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a value between 1 and 12.");
            return;
        }

        int firstDay = getFirstDayOfMonth(year, month);
        int numDays = getDaysInMonth(month, year);
        String monthName = getMonthName(month);

        System.out.println("\n--- " + monthName + " " + year + " ---");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print days of the month
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            // Move to the next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        input.close();
    }
}