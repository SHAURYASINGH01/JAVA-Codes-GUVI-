import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        sc.nextLine();
        var list = new ArrayList<String>();
        for (var i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        //..... YOUR CODE STARTS HERE .....
        
        list.stream()
            .filter(word -> word.length() < 5) 
            .map(String::toUpperCase) 
            .forEach(System.out::println);
        
        //..... YOUR CODE ENDS HERE .....
    }
}
