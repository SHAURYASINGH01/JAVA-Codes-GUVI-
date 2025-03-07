import java.util.*;
import java.util.function.Predicate;

@FunctionalInterface
interface Condition {
    //..... YOUR CODE STARTS HERE .....
        boolean test(int number); // Method to test the condition

    
    
    //..... YOUR CODE ENDS HERE .....
}

public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
         Scanner sc = new Scanner(System.in);
        
        // Read the number of integers
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        // Read n integers into the list
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        // Create a Condition to filter out even numbers using a lambda expression
        Condition isOdd = number -> number % 2 != 0;

        // Filter the list using the condition
        for (int number : numbers) {
            if (isOdd.test(number)) { // Test if the number is odd
                System.out.println(number); // Print odd numbers
            }
        }
        
        
        //..... YOUR CODE ENDS HERE .....
    }
}
