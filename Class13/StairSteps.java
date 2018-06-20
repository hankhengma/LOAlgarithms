/****************
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
******************/
import java.util.*;

public class StairSteps {
	public int steps(int n) {
		if (n <= 2) {
			return n < 0 ? -1 : n;
		}

		int[] array = new int[n + 1];
		array[1] = 1;
		array[2] = 2;
			
		for (int i = 3; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
	}
}

/**************
m[1] = 1; _
m[2] = 2; <= _ | _ && _ _
m[3] = m[2] + m[1]; <= 3; _ _ | _ && - | _ _ 
m[4] = m[3] + m[2]; <= _ _ _ | _ && _ _ | _ _ 
...
m[n] = m[n-1] + m[n]
**************/