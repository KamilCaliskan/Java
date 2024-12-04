import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // Given Physics and History scores
        int[] physicsScores = {15, 12, 8, 8, 7, 7, 7, 6, 5, 3};
        int[] historyScores = {10, 25, 17, 11, 13, 17, 20, 13, 9, 15};
        
        // Number of students
        int n = physicsScores.length;
        
        // Calculate the necessary sums
        int sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += physicsScores[i];
            sumY += historyScores[i];
            sumXY += physicsScores[i] * historyScores[i];
            sumX2 += physicsScores[i] * physicsScores[i];
            sumY2 += historyScores[i] * historyScores[i];
        }
        
        // Apply the Pearson correlation formula
        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        
        // Calculate the correlation coefficient
        double r = numerator / denominator;
        
        // Print the result rounded to 3 decimal places
        System.out.printf("%.3f\n", r);
    }
}
