public class LongestAscedingSubarray {
	public int subarray(int[] array) {
		// Assumption: array is not null;
		if (array.length == 0) {
			return 0;
		}
		
		int subarrayLength = 1;
		int globalMax = 1;
		// base cause: m[1] = 1;
		// induction rule :
		// m[i] = m[i - 1] + 1;
		// if array[i] > array[i - 1] sublength + 1;
		// otherwise sublength sets to 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				// subarrayLength += 1;
				if (++subarrayLength > globalMax) {
					globalMax = subarrayLength;
				}
			} else {
				subarrayLength = 1;
			}
		}
		return globalMax;
	}
}