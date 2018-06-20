// time: O(n)
// space: O(1)

public class Solution {
	public int[] moveZero(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		return moveZeroHelper(array, 0, array.length - 1);
	}

	private int[] moveZeroHelper(int[] array, int left, int right) {
		if (left >= right) {
			return array;
		}

		int leftIndex = left;
		int rightIndex = right;

		while (leftIndex <= rightIndex) {
			if (array[leftIndex] > 0) {
				leftIndex++;
			} else if (array[rightIndex] == 0) {
				rightIndex--;
			} else {
				swap(array, leftIndex++, rightIndex--);
			}
		}
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}