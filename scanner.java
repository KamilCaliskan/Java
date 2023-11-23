/* In this challenge, 
  you must read integers from stdin and then print them to stdout
  Each integer must be printed on a new line */


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read integers from stdin
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();

        // Close the scanner as there is no more input to read
        scanner.close();

        // Print integers to stdout on new lines
        System.out.println(firstInt);
        System.out.println(secondInt);
        System.out.println(thirdInt);
    }
}

    
