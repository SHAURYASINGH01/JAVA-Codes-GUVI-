import java.util.*;
import java.util.function.BiFunction;

@FunctionalInterface
interface Combiner {
    //..... YOUR CODE STARTS HERE .....
     int combine(int a, int b); // Method to combine two integers
    
    
    //..... YOUR CODE ENDS HERE .....
}

public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
     Scanner sc = new Scanner(System.in);
        
        // Read the number of integers in each list
        int n = sc.nextInt();
        
        // Create two lists for the integers
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Read integers for the first list
        for (int i = 0; i < n; i++) {
            list1.add(sc.nextInt());
        }

        // Read integers for the second list
        for (int i = 0; i < n; i++) {
            list2.add(sc.nextInt());
        }

        // Create a Combiner to add two integers
        Combiner adder = (a, b) -> a + b;

        // Create a list to store the combined results
        List<Integer> combinedList = new ArrayList<>();

        // Combine corresponding elements from the two lists
        for (int i = 0; i < n; i++) {
            int combinedValue = adder.combine(list1.get(i), list2.get(i));
            combinedList.add(combinedValue);
        }

        // Print the resulting combined list
        for (int value : combinedList) {
            System.out.println(value);
        }
    
    
        //..... YOUR CODE ENDS HERE .....
    }
}
