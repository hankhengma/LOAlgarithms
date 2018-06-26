public class ArrayDeduplicationII {
	public int[] dedup(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}

		int slow = 2;// exclusive;
		int fast = 2;

		while (fast < array.length) {
			if (array[fast] != array[slow - 2]) {
				array[slow++] = array[fast++];
			} else {
				fast++;
			}
		}
		return Arrays.copyOf(array, slow);
	}
}