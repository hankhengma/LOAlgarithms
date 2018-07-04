// Using Array to mimic the stack to reduce space complexity;


public class ArrayDeduplicationIV {
	public int[] dedup(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int slow = -1;
		int fast = 0;

		while (fast < array.length) {
			if (slow == -1 || array[slow] != array[fast]) {
				array[++slow] = array[fast++];
			} else {
				while (fast < array.length && array[slow] == array[fast]) {
					++fast;
				}
				--end;
			}
		}
		return Arrays.copyOf(array, slow);
	}
}