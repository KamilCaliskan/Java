import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Arrays;


public class StringSplit {
    public static String[] solution(String s) {
        // Check if the length of the string is odd, append an underscore to make it even
        if (s.length() % 2 != 0) {
            s += "_";
        }

        // Calculate the number of pairs
        int numPairs = s.length() / 2;

        // Initialize the array to store the pairs
        String[] result = new String[numPairs];

        // Split the string into pairs
        for (int i = 0; i < numPairs; i++) {
            result[i] = s.substring(2 * i, 2 * i + 2);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        String[] result1 = solution("abc");
        String[] result2 = solution("abcdef");

        // Print the results
        System.out.println(Arrays.toString(result1)); // Output: [ab, c_]
        System.out.println(Arrays.toString(result2)); // Output: [ab, cd, ef]
    }
}
