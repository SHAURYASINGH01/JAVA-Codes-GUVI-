Ques 2:
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
          
            String input = scanner.nextLine();

            // Handle edge cases
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be null or empty.");
            }

            // Encrypt and decrypt the string
            String encrypted = encrypt(input);
            String decrypted = decrypt(encrypted);

            System.out.println("Encrypted String: " + encrypted);
            System.out.println("Decrypted String: " + decrypted);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String encrypt(String input) {
        // Apply Caesar cipher with shift of 3 positions
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encrypted.append((char) ((ch - base + 3) % 26 + base));
            } else if (Character.isDigit(ch)) {
                encrypted.append((char) ((ch - '0' + 3) % 10 + '0'));
            } else {
                encrypted.append(ch); // For non-alphanumeric characters, no change
            }
        }

        // Reverse the encrypted string
        return encrypted.reverse().toString();
    }

    private static String decrypt(String encrypted) {
        // Reverse the string to get the original Caesar cipher result
        StringBuilder reversed = new StringBuilder(encrypted).reverse();

        // Apply reverse Caesar cipher with shift of 3 positions
        StringBuilder decrypted = new StringBuilder();
        for (char ch : reversed.toString().toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                decrypted.append((char) ((ch - base - 3 + 26) % 26 + base));
            } else if (Character.isDigit(ch)) {
                decrypted.append((char) ((ch - '0' - 3 + 10) % 10 + '0'));
            } else {
                decrypted.append(ch); // For non-alphanumeric characters, no change
            }
        }

        return decrypted.toString();
    }
}
