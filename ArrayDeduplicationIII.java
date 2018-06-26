public class ArrayDeduplicationIII {
	public int[] dedup(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}

		int slow = 0;// exclusive
		int fast = 0;

		while (fast < array.length) {
			int cur = fast;
			while (fast < array.length && array[cur] == array[fast]) {
				fast++;
			}
			if (fast - cur > 1) {
				continue;
			} else {
				array[slow++] = array[cur];
			}
		}
		return Arrays.copyOf(array, slow);
	}
}