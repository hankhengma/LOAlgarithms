public class Solution {

	public int[] mergeSort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}

		mergeSortHelper(array, 0, array.length - 1);
		return array;
	}

	private void mergeSortHelper(int[] array, int left, int right) {
		if (left >= right) return;

		int mid = left + (right - left) / 2;
		mergeSortHelper(array, left, mid);
		mergeSortHelper(array, mid + 1, right);
		merge(array, left, mid, right);
	}

	private void merge(int[] array, int left, int mid, int right) {
		int[] helperArray = new int[array.length];
		for (int i = left; i <= right; i++) {
			helperArray[i] = array[i];
		}

		int leftIndexOfHelper = left;
		int rightIndexOfHelper = mid + 1;

		while (leftIndexOfHelper <= mid && rightIndexOfHelper <= right) {
			if (helperArray[leftIndexOfHelper] <= helperArray[rightIndexOfHelper]) {
				array[left++] = helperArray[leftIndexOfHelper++];
			}
			else {
				array[left++] = helperArray[rightIndexOfHelper++];
			}
		}
		while (leftIndexOfHelper <= mid) {
			array[left++] = helperArray[leftIndexOfHelper++];
		}
	}

	private void swap(int[] array, int a, int b) {
		int temp;
		temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}