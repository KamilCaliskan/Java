/*
   This line prints the final result, which is the maximum number of unique 
    integers among all possible contiguous subarrays of size m

    That's the explanation for each line in the provided Java code 
    The code is designed to find the maximum number of unique 
    integers among all contiguous subarrays of size m in the given input
*/



import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUniqueCount = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add the current number to the deque and set
            deque.addLast(num);
            uniqueNumbers.add(num);

            // If the size of the deque exceeds the subarray size, remove the front element
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                // If the removed element was unique, decrement the unique count
                if (!deque.contains(removed)) {
                    uniqueNumbers.remove(removed);
                }
            }

            // Update the maximum unique count
            maxUniqueCount = Math.max(maxUniqueCount, uniqueNumbers.size());
        }

        System.out.println(maxUniqueCount);
    }
}
