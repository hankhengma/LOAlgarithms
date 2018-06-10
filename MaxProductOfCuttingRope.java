public class MaxProductOfCuttingRope {
	public int maxProduct(int length) {
		int[] maxProd = new int[length + 1];
		// according to the problem
		// the rope must be at least 2m long;
		maxProd[0] = 0;
		maxProd[1] = 0;
		maxProd[2] = 1;
		
		for (int i = 3; i <= length; i++) {
			int curMax = 0;
			for (int j = 1; j < i; j++) {
				if(curMax < j * Math.max(i - j, m[i - j])) {
					curMax = j * Math.max(i - j, m[i - j])
				}
				m[i] = curMax;
			}
		}
		return m[length];
	}
}