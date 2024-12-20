import java.util.*;
public class Main {
    public static void main(String[] args) {
       //..... YOUR CODE STARTS HERE .....
       
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input
        
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine()); // Read each word on a new line
        }
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                longestWords.clear();
                longestWords.add(word);
                maxLength = length;
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }
        for (String longestWord : longestWords) {
            System.out.println(longestWord);
        }
       
      //..... YOUR CODE ENDS HERE .....
    }
}
