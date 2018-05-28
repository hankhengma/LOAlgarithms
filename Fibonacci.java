public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
 
    
    if (K < 0) {
    	return 0;
    }
    /*******************************************
    // the code will cause stackOverflowed.
    else {
    	if (K == 0) {
    		return 0;
      }
      else if (K == 1) {
        return 1;
      }
      else {
        return fibonacci(K - 1) + fibonacci(K - 2);
      }
    }
    ******************************************/
		else {
      if (K <= 0) {
      	return 0;
      }
      long[] array = new long[K + 1];
      array[1] = 1;
      
      for (int i = 2; i <= K; i++) {
      	array[i] = array[i - 2] + array[i - 1];
      }
      return array[K];
      
    }
  }
}
