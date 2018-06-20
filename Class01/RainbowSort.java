// time: O(n)
// space: O(1)
public class Solution {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		rainbowSort(array, 0, array.length - 1);
		return array;
	}

	private void rainbowSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		int negtive = left;
		int zero = left;
		int positive = right;

		while (zero <= positive) {
			if (array[zero] == -1) {
				swap(array, negtive++, zero++);
			} else if (array[zero] == 0) {
				zero++;
			} else {
				swap(array, zero, positive--);
			}
		}

	}

	private void swap(int[] array, int left, int right) {
		int temp = array[right];
		array[right] = array[left];
		array[left] = temp;
	}
}