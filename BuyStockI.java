/************************
A 2 3 2 1 4 5
M 0 1 1 0
m0 0; gm = 0
m1 3-2 = 1 gm = 1
m2 max(a2-a0, a2-a1); == max(0, -1); gm = 1
m3 max(a3-a2, a3-a2, a3-a0) = max(-1,-2,-1) = -1; gm = 0
m4 max(a4-a3...) = max(3,2,1,2) = 3 gm = 3;
m5 max(...) ====== max(1,4,3,2,3) = 4 gm = 4;

A 1 4 5 3 6 2
M 0 3 4 4 5 5

m[0] = 0;

m[i] presents the max profit till ith day.

if a[i] - a[globalMin] > m[i] m[i] = max()
**************************/
public class BuyStockI {
	public int maxProfit(int[] array) {
		int globalMax = 0;

        if (array == null || array.length == 0) {
            return globalMax;
        }

        int[] max = new int[array.length];

        for (int i = 1; i < array.length; i++) {
        	int cur;
        	for (int j = i - 1; j >= 0; j--) {
        		cur = Math.max(cur, a[i] - a[j]);
        		globalMax = Math.max(globalMax, cur);
        	}
        	m[i] = Math.max(globalMax, cur);
        }
        return globalMax;
    }
}
