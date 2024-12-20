import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //..... YOUR CODE STARTS HERE .....
        
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(scanner.nextLine());
            b = Integer.parseInt(scanner.nextLine());
            int result = a / b;
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Operation Completed");
        }
        scanner.close();
        
        //..... YOUR CODE ENDS HERE .....
    }
}