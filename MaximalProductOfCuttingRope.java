public class MaximalProductOfCuttingRope {
	public int max(int length) {
		// base case: m[0] = 0, m[1] = 0;
		// induction rule: m[i] = max(m[i-1], i) * i;
		if (length <= 1) {
			return 0;
		}
		// base case;
		int[] m = new int[length + 1];
		m[0] = 0;
		m[1] = 0;
		// Linear Scan;
		for (int i = 1; i <= length; i++) {
			int curBest = 0;
			// look back;
			for (int j = 1; j < i; j++) {
				// induction rule:
				curBest = Math.max(curBest, Math.max(j, m[j]) * (i - j));
			}
			m[i] = curBest;
		}
		return m[n];
	}
}