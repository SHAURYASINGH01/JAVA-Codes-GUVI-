import java.util.*;

class UserActivityTracker {
    //..... YOUR CODE STARTS HERE .....
    
    private Map<String, Set<String>> userActivities;
    public UserActivityTracker() {
        userActivities = new HashMap<>();
    }
    public void addActivity(String userId, String activity) {
        userActivities.putIfAbsent(userId, new HashSet<>());
        userActivities.get(userId).add(activity);
    }
    public void displayActivities(String userId) {
        if (!userActivities.containsKey(userId) || userActivities.get(userId).isEmpty()) {
            System.out.println("No activities found.");
        } else {
            List<String> activities = new ArrayList<>(userActivities.get(userId));
            Collections.sort(activities);
            for (String activity : activities) {
                System.out.println(activity);
            }
        }
    }
    
    //..... YOUR CODE ENDS HERE .....
}
public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
    
    Scanner scanner = new Scanner(System.in);
        UserActivityTracker tracker = new UserActivityTracker();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            if (parts[0].equals("ADD_ACTIVITY")) {
                String userId = parts[1];
                String activity = parts[2];
                tracker.addActivity(userId, activity);
            } else if (parts[0].equals("DISPLAY_ACTIVITIES")) {
                String userId = parts[1];
                tracker.displayActivities(userId);
            }
        }
        scanner.close();
    
        //..... YOUR CODE ENDS HERE .....
    }
}
