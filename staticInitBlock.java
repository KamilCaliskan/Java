import java.io.*;
import java.util.*;

public class Solution {

    // Static variables for breadth and height
    static int B;
    static int H;
    static boolean flag = true;

    // Static initialization block
    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        scanner.close();
        
        // Validate the values of B and H
        if (B <= 0 || H <= 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        // Check the flag before calculating the area
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
