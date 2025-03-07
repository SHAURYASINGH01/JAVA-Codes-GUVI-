import java.util.*;

public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
        
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        String[] words = input.split("\\W+"); // Split by non-word characters
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int freqCompare = entry2.getValue().compareTo(entry1.getValue());
            return (freqCompare != 0) ? freqCompare : entry1.getKey().compareTo(entry2.getKey());
        });
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        //..... YOUR CODE ENDS HERE .....
    }
}
