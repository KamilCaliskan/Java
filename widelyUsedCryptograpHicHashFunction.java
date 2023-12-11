/*
MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a

128-bit hash value Here are some common uses for MD5:

    To store a one-way hash of a password.
    To provide some assurance that a transferred file has arrived intact
*/
/*
  Bu Java programı,
  kullanıcıdan alfanümerik bir dize girdisi alır
  bu girdinin MD5 özetini hesaplar ve ardından bu özeti ekrana yazdırır
*/

import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input from the user
        String input = scanner.nextLine();

        try {
            // Compute MD5 hash
            String md5Hash = getMD5Hash(input);

            // Print the MD5 hash
            System.out.println(md5Hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String getMD5Hash(String input) throws NoSuchAlgorithmException {
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add the input string bytes to the message digest
        md.update(input.getBytes());

        // Get the hash bytes
        byte[] hashBytes = md.digest();

        // Convert the hash bytes to a hexadecimal string representation
        StringBuilder md5Hash = new StringBuilder();
        for (byte b : hashBytes) {
            md5Hash.append(String.format("%02x", b));
        }

        return md5Hash.toString();
    }
}
