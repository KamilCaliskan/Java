import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Remove case sensitivity by converting both strings to lower case
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        // If the lengths are not the same, they cannot be anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        
        Arrays.sort(aArray);
        Arrays.sort(bArray);
        
        // Compare sorted arrays
        return Arrays.equals(aArray, bArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input strings
        String a = sc.nextLine();
        String b = sc.nextLine();
        
        // Check if they are anagrams and print the result
        if (isAnagram(a, b)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
        
        sc.close();
    }
}
