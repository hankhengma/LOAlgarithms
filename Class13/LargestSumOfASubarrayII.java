public class LargestSumOfASubarrayII {
	public List<Integer> largestSum(int[] array) {
		List<Integer> result = new ArrayList<>();
		if (array == null || array.length == 0) {
			return result;
		}
		// the final result of the subarray's left index;
		int globalLeft = 0;
		// the final result of the subarray's right index;
		int globalRight = 0;

		// the index for the current processing element. when the sum is less than 0, it will be updated to the current index.
		int curLeft = 0

		int[] sum = new int[array.length];
		sum[0] = array[0];
		// result the largest sum; when it is updated the subarray's left and right index will update.
		int globalMax = 0;

		for (int i = 1; i < array.length; i++) {
			if (sum[i-1] < 0) {
				curLeft = i;
				sum[i] = array[i];
			} else {
				sum[i] = sum[i-1] + array[i];
			}

			if (sum[i] > globalMax) {
				globalMax = sum[i];
				globalLeft = curLeft;
				globalRight = i;
			}
		}
		result.add(globalLeft);
		result.add(globalRight);
		return result;
	}
}