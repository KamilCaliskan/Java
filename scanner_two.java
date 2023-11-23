/*
There are three lines of output:

    On the first line, print String: followed by the unaltered String read from stdin
    On the second line, print Double: followed by the unaltered double read from stdin
    On the third line, print Int: followed by the unaltered integer read from stdin

To make the problem easier, a portion of the code is already provided in the editor

Note: If you use the nextLine() method immediately following the nextInt() method, 
recall that nextInt() reads integer tokens; because of this, the last newline character for that line of integer input is still queued in the input buffer and 
the next nextLine() will be reading the remainder of the integer line (which is empty)

Sample Input:

42
3.1415
Welcome to HackerRank's Java tutorials!
*/


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read an integer, a double, and a String from stdin
        int intValue = scanner.nextInt();
        double doubleValue = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left after reading double
        String stringValue = scanner.nextLine();

        // Print the values according to the specified format
        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + intValue);

        // Close the scanner
        scanner.close();
    }
}
