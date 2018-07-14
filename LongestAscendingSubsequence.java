public class LongestAscendingSubsequence {
	public int LongestAscendingSubsequence(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int[] m = new int[array.length + 1];
		int globalMax = 0;
		m[0] = 1;
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] < array[j]) {
					m[i] = 1;
				} else {
					m[i] = m[j] + 1;
				}
			}
			globalMax = Math.max(m[i], globalMax);
		}
	}
}

/*********************
m[i] the length of the subsequence from 0 to ith
i 0 1 2 3 4 5 6 7
a 7 2 3 1 5 8 9 6 
m 1 1 2 1 3 4 5 4

m[0] = 1;
m[i] 大几个数 就是个数+1