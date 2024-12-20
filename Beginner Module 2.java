Ques 2:

import java.util.Scanner;
public class Main {
    private static final int REGULAR_HOURS = 160;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    public static double calculateSalary(double hourlyWage, int hoursWorked) {
        double totalSalary;
        if (hoursWorked <= REGULAR_HOURS) {
            totalSalary = hoursWorked * hourlyWage;
        } else {
            int overtimeHours = hoursWorked - REGULAR_HOURS;
            totalSalary = (REGULAR_HOURS * hourlyWage) + (overtimeHours * hourlyWage * OVERTIME_MULTIPLIER);
        }
        return totalSalary;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = scanner.nextInt();
        String[] employeeNames = new String[numberOfEmployees];
        double[] hourlyWages = new double[numberOfEmployees];
        int[] hoursWorked = new int[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            scanner.nextLine();
            employeeNames[i] = scanner.nextLine();
            hourlyWages[i] = scanner.nextDouble();
            hoursWorked[i] = scanner.nextInt();
        }
        for (int i = 0; i < numberOfEmployees; i++) {
            double totalSalary = calculateSalary(hourlyWages[i], hoursWorked[i]);
            System.out.printf("Total Salary: %.2f%n", totalSalary);
        }
        scanner.close();
    }
}
