Beginner Level:

Ques 1:

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = scanner.nextInt();
        int numSubjects = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine(); // To consume the leftover newline
            studentNames[i] = scanner.nextLine();

            for (int j = 0; j < numSubjects; j++) {
                double grade;
                try {
                    grade = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid grade entered for " + studentNames[i]);
                    return;
                }

                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade entered for " + studentNames[i]);
                    return;
                } else {
                    grades[i][j] = grade;
                }
            }
        }

        double highestGrade = Double.MIN_VALUE;
        double lowestGrade = Double.MAX_VALUE;
        String highestGradeStudent = "";
        String lowestGradeStudent = "";

        System.out.println("Average Grades:");
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;

            for (int j = 0; j < numSubjects; j++) {
                sum += grades[i][j];

                if (grades[i][j] > highestGrade) {
                    highestGrade = grades[i][j];
                    highestGradeStudent = studentNames[i];
                }

                if (grades[i][j] < lowestGrade) {
                    lowestGrade = grades[i][j];
                    lowestGradeStudent = studentNames[i];
                }
            }

            double average = sum / numSubjects;
            System.out.printf("%s: %.2f\n", studentNames[i], average);
        }

        // Corrected format specifiers for printing the highest and lowest grades
        System.out.printf("Highest Grade: %.0f (%s)\n", highestGrade, highestGradeStudent);
        System.out.printf("Lowest Grade: %.0f (%s)\n", lowestGrade, lowestGradeStudent);

        scanner.close();
    }
}
