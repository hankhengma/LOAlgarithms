public class LargestSumOfASubarray {
	public int largestSum(int[] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}

		int prevMax = array[0];
		int curMax = array[0];

		for (int i = 1; i < array.length; i++) {
			prevMax = Math.max(array[i], prevMax + array[i]);
			curMax = Math.max(curMax, prevMax);
		}
		return curMax;
	}

	public int LargestSumI(int[] array) {
		if (array.length < 1) {
			return 0;
		}

		int[] sum = new int[array.length];
		sum[0] = array[0];
		int globalMax = array[0];

		for (int i = 1; i < array.length; i++) {
			if (sum[i-1] < 0) {
				sum[i] = array[i];
			} else {
				sum[i] = array[i - 1] + array[i];
			}
			globalMax = Math.max(globalMax, sum[i]);
		}
		return globalMax;
	}
}