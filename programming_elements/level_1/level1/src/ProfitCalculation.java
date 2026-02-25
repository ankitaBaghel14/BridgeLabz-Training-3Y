import java.util.Scanner;

class ProfitCalculation {
    public static void main(String[] args) {

        double costPrice;
        double sellingPrice;
        double profit;
        double profitPercentage;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Cost Price (INR): ");
        costPrice = input.nextDouble();

        System.out.print("Enter Selling Price (INR): ");
        sellingPrice = input.nextDouble();

        profit = sellingPrice - costPrice;
        profitPercentage = (profit / costPrice) * 100;

        System.out.println("The Cost Price is INR " + costPrice +
                " and Selling Price is INR " + sellingPrice + "\n" +
                "The Profit is INR " + profit +
                " and the Profit Percentage is " + profitPercentage);

        input.close();
    }
}
