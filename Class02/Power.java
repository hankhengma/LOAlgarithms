// public class Power {
// 	public long power(int a, int b) {
// 		if (a == 0) {
// 			return 0;
// 		}

// 		if ( b == 0) {
// 			return 1;
// 		}

// 		if ( b % 2 == 0) {
// 			return power(a, b / 2) * power(a, b / 2);
// 		}
// 		else {
// 			return a*power(a, b / 2) * power(a, b / 2);
// 		}
// 	}
// }
public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (a == 0) {
    	return 0;
    }
    if (b == 0) {
    	return 1;
    }
    
    //int c = b % 2 == 0 ? 1 : a;
    //return power(a, b / 2) * power(a, b / 2) * c;
    // the code above will cause stackoverflow as too many recursions.
    long halfPower = power(a, b / 2);
    long c = b % 2 == 0 ? 1 : a;
    return c * halfPower * halfPower;
  }
}
