//Time: O(n^2)
//Space: O(1)


public class Solution {
	public int[] select(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int globalMinIndex = Integer.MIN_VALUE;

		for (int i = 0; i < array.length - 2; i++) {
			globalMinIndex = i;
			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[j] < array[globalMinIndex]) {
					globalMinIndex = j;
				}
			}
			swap(array, i, globalMinIndex);
		}
		return array;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[right];
		array[right] = array[left];
		array[left] = temp;
	}
}