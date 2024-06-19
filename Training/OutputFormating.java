import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            
            // Print the formatted output
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");

    }
}


/*
%-15s: This formats the String s1 to be left-justified 
within a width of 15 characters
%03d: This formats the integer x to be printed as a three-digit number with 
leading zeros if necessary (%03d)
*/

/*
To solve this problem using Java's System.out.printf, 
you need to format the output such that each String is left-justified 
within a fixed width and each integer is printed with leading zeros if necessary
*/
