class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final int RATE = 1000; // per day

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    int calculateCost() {
        return rentalDays * RATE;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                ", Days: " + rentalDays + ", Cost: " + calculateCost());
    }
}
