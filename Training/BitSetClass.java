/*
This code reads the input, performs the specified operations on two BitSet objects
  and prints the number of set bits after each operation 
The operations are implemented based on the given conditions
*/



import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BitSet bitSet1 = new BitSet(n);
        BitSet bitSet2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            int operand1 = scanner.nextInt();
            int operand2 = scanner.nextInt();

            switch (operation) {
                case "AND":
                    if (operand1 == 1) {
                        bitSet1.and(bitSet2);
                    } else {
                        bitSet2.and(bitSet1);
                    }
                    break;
                case "OR":
                    if (operand1 == 1) {
                        bitSet1.or(bitSet2);
                    } else {
                        bitSet2.or(bitSet1);
                    }
                    break;
                case "XOR":
                    if (operand1 == 1) {
                        bitSet1.xor(bitSet2);
                    } else {
                        bitSet2.xor(bitSet1);
                    }
                    break;
                case "FLIP":
                    if (operand1 == 1) {
                        bitSet1.flip(operand2);
                    } else {
                        bitSet2.flip(operand2);
                    }
                    break;
                case "SET":
                    if (operand1 == 1) {
                        bitSet1.set(operand2);
                    } else {
                        bitSet2.set(operand2);
                    }
                    break;
            }

            System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
        }

        scanner.close();
    }
}
