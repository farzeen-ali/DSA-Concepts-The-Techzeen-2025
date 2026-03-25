import java.util.Scanner;

public class SimpleHashing {

    // Custom Hash Function (NO built-in hashing algorithms)
    public static String generateHash(String input) {

        int hash = 7;

        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }

        // Ensure positive value
        return Integer.toHexString(Math.abs(hash));
    }

    // Simple Salt Generator
    public static String generateSalt(int index) {
        return "SALT" + (index * 13 + 7);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] passwords = new String[3];
        String[] hashes = new String[3];

        // Take 3 passwords
        for (int i = 0; i < 3; i++) {

            System.out.print("Enter Password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();

            String salt = generateSalt(i);

            // Best practice: salt + password
            String saltedPassword = salt + passwords[i];

            hashes[i] = generateHash(saltedPassword);
        }

        // Print results
        System.out.println("\n--- Hashed Passwords ---");

        for (int i = 0; i < 3; i++) {
            System.out.println("Password " + (i + 1) + " Hash: " + hashes[i]);
        }

        sc.close();
    }
}