Ques 3:
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    private static final List<String> errorMessages = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of files
        int numFiles = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Read the filenames
        String[] fileNames = new String[numFiles];
        for (int i = 0; i < numFiles; i++) {
            fileNames[i] = scanner.nextLine();
        }

        // Determine if contents are provided directly after filenames
        boolean contentProvidedDirectly = false;
        List<String> fileContents = new ArrayList<>();
        for (int i = 0; i < numFiles; i++) {
            if (scanner.hasNextLine()) {
                fileContents.add(scanner.nextLine());
                contentProvidedDirectly = true;
            }
        }

        // Create a thread pool with a number of threads equal to the number of input files
        ExecutorService executor = Executors.newFixedThreadPool(numFiles);
        List<Future<String>> futures = new ArrayList<>();

        // Submit tasks for each file or simulated content
        for (int i = 0; i < numFiles; i++) {
            String fileName = fileNames[i];
            if (contentProvidedDirectly) {
                // If content is directly provided, process it as is
                String content = fileContents.get(i);
                futures.add(executor.submit(() -> processContent(fileName, content)));
            } else {
                // Otherwise, attempt to read content from the file system
                futures.add(executor.submit(() -> processFile(fileName)));
            }
        }

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        // Print results and error messages to stdout
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                System.out.println("Error processing file: " + e.getCause().getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
                System.out.println("Task was interrupted.");
            }
        }

        // Print any error messages
        if (!errorMessages.isEmpty()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("outputError.txt", true))) {
                for (String errorMessage : errorMessages) {
                    System.out.println(errorMessage);
                    writer.println(errorMessage);
                }
            } catch (IOException e) {
                // Print the error for writing issues directly
                System.out.println("Error writing to outputError.txt: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Method to process a file, read its content, and count words
    private static String processFile(String fileName) {
        try {
            String content = readFile(fileName);
            int wordCount = countWords(content);
            return fileName + ": " + wordCount + " words";
        } catch (IOException e) {
            String errorMessage = "Error reading file: " + fileName;
            errorMessages.add(errorMessage);
            return errorMessage;
        } catch (Exception e) {
            String errorMessage = "Error processing file: " + fileName;
            errorMessages.add(errorMessage);
            return errorMessage;
        }
    }

    // Method to simulate processing content directly provided
    private static String processContent(String fileName, String content) {
        try {
            int wordCount = countWords(content);
            return fileName + ": " + wordCount + " words";
        } catch (Exception e) {
            errorMessages.add("Error processing content: " + fileName);
            return "Error processing content: " + fileName;
        }
    }

    // Method to read the content of a file
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString().trim();
    }

    // Method to count words in the given content
    private static int countWords(String content) {
        return content.isEmpty() ? 0 : content.split("\\s+").length;
    }
}

