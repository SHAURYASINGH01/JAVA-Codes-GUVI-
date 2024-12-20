Ques 1:
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String major;

    public Student(int id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Major: %s", id, name, age, major);
    }
}

public class Main {
    // Static list to maintain state across operations
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
       
        
        // Read the user's choice
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
               
                String addDetails = scanner.nextLine();
                String[] addTokens = addDetails.split("\\s+");
                addStudent(addTokens);
                break;
            case 2:
                
                String deleteDetails = scanner.nextLine();
                String[] deleteTokens = deleteDetails.split("\\s+");
                deleteStudent(deleteTokens);
                break;
            case 3:
                displayStudents();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    private static void addStudent(String[] tokens) {
        try {
            // Parse student details from the tokens
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String major = tokens[3];

            // Check if a student with the same ID already exists
            if (students.stream().anyMatch(student -> student.id == id)) {
                System.out.println("A student with this ID already exists. Please use a unique ID.");
                return;
            }

            // Add student to the list
            Student student = new Student(id, name, age, major);
            students.add(student);
            System.out.println("Student added: " + student);
        } catch (Exception e) {
            System.out.println("Error adding student. Please ensure you enter the details in the correct format.");
        }
    }

    private static void deleteStudent(String[] tokens) {
        try {
            // Parse student ID to delete
            int id = Integer.parseInt(tokens[0]);

            // Find and remove the student by ID
            boolean found = students.removeIf(student -> student.id == id);

            if (found) {
                System.out.println("Student with ID " + id + " is deleted.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting student. Please ensure you enter a valid ID.");
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
