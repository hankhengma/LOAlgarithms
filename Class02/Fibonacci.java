import java.util.*;

public class Solution {
    // Dynamic Programming
    public long fibonacci(int K) {
        // Write your solution here
        if (K <= 0) {
            return 0;
        }

        long[] array = new long[K + 1];
        array[0] = 0;
        array[1] = 1;
    
        for (int i = 2; i <= K; i++) {
    	   array[i] = array[i - 2] + array[i - 1];
        }
        return array[K];
    }

    // recursion + memorization
    public long fibonacci(int K) {
        if (K < 2) {
            return K;
        }
        Map<Integer, Long> hashmap = new HashMap<>();
        hashmap.put(0, (long)0);
        hashmap.put(1, (long)1);
        if (!hashmap.containsKey(K)) {
            hashmap.put(K, fibonacci(K - 1) + fibonacci(K - 2));
        }
        return hashmap.get(K);
    }
}
