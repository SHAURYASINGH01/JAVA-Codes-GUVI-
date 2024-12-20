import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    //..... YOUR CODE STARTS HERE .....
    
    private String name;
    private double totalMarks;
    private int marksCount;
    private char grade;
    public Student(String name) {
        this.name = name;
        this.totalMarks = 0;
        this.marksCount = 0;
    }
    public void addMarks(double mark) {
        totalMarks += mark;
        marksCount++;
        System.out.println("Marks added");
    }
    public void calculateGrade() {
        if (marksCount > 0) {
            double average = totalMarks / marksCount;
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Grade calculated");
        } else {
            System.out.println("No marks available to calculate grade");
        }
    }
    public void displayDetails() {
        double average = marksCount > 0 ? totalMarks / marksCount : 0;
        System.out.printf("%s: %.1f - %c%n", name, average, grade); // Changed to %.1f
    }
    
    //..... YOUR CODE ENDS HERE .....
}
public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
    
    Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> studentMap = new HashMap<>();
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];
            Student student = studentMap.computeIfAbsent(name, Student::new);
            if (command.equals("add")) {
                double mark = Double.parseDouble(input[2]);
                student.addMarks(mark);
            } else if (command.equals("calculate")) {
                student.calculateGrade();
            } else if (command.equals("display")) {
                student.displayDetails();
            }
        }
        scanner.close();
        
        //..... YOUR CODE ENDS HERE .....
    }
}
