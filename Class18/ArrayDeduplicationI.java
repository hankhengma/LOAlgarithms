public class ArrayDeduplicationI {
	public int[] dedup(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int slow = 1;// exclusive array[slow]
		int fast = 1;

		while (fast < array.length) {
			if (array[slow - 1] == array[fast]) {
				fast++;
			} else {
				array[slow++] == array[fast++];
			}
		}
		return Arrays.copyOf(array, slow);
	}
}
