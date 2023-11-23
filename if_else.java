/* Given an integer,n, perform the following conditional actions:
If n is odd, n print Weird
If nis even and in the inclusive range of 2 to 5, n print Not Weird
If n is even and in the inclusive range of 6 to 20, n print Weird
If n is even and greater than 20, n print Not Weird

Complete the stub code provided in your editor to print whether or not
is weird */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the integer from stdin
        int n = scanner.nextInt();

        // Close the scanner as there is no more input to read
        scanner.close();

        // Check the conditions and print the result
        if (n % 2 != 0) {
            // n is odd
            System.out.println("Weird");
        } else {
            // n is even
            if (n >= 2 && n <= 5) {
                System.out.println("Not Weird");
            } else if (n >= 6 && n <= 20) {
                System.out.println("Weird");
            } else {
                System.out.println("Not Weird");
            }
        }
    }
}
