Ques 1:

import java.util.Scanner;

class Car {
    String type;

    // Constructor
    public Car(String type) {
        this.type = type;
    }

    // Method to calculate rental charges for standard car types
    public double calculateRentalCharges(int days) {
        double dailyRate;

        switch (type.toLowerCase()) {
            case "standard":
                dailyRate = 2000;
                break;
            case "suv":
                dailyRate = 4000;
                break;
            default:
                dailyRate = 2000;
                break;
        }

        return dailyRate * days;
    }

    // Overloaded method to calculate rental charges with additional options
    public double calculateRentalCharges(int days, String... options) {
        double baseCharge = calculateRentalCharges(days);
        double optionsCharge = 0;

        for (String option : options) {
            switch (option.toLowerCase()) {
                case "gps":
                    optionsCharge += 500 * days;
                    break;
                case "child seat":
                    optionsCharge += 200 * days;
                    break;
                default:
                    break;
            }
        }

        return baseCharge + optionsCharge;
    }

    // Method to display car details and charges
    public void displayRentalDetails(int days, String... options) {
        double totalCharges = calculateRentalCharges(days, options);
        System.out.println(String.format("Total Rental Charges: ₹%.2f", totalCharges));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input car details
        String type = scanner.nextLine().trim();

        // Input number of days
        int days = scanner.nextInt();
        scanner.nextLine(); 

        // Check for additional options input (optional)
        String optionsInput = "";
        if (scanner.hasNextLine()) {
            optionsInput = scanner.nextLine().trim();
        }

        // Parse options if provided
        String[] options = optionsInput.isEmpty() ? new String[0] : optionsInput.split(",\\s*");

        // Create a Car object and calculate/display rental details
        Car car = new Car(type);
        car.displayRentalDetails(days, options);

        scanner.close();
    }
}
