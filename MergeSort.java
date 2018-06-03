// Time: O(nlogn)
// Space: O(n)
public class Solution {

	public int[] mergeSort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}
		int[] helperArray = new int[array.length];
		mergeSortHelper(array, helperArray, 0, array.length - 1);
		return array;
	}

	private void mergeSortHelper(int[] array, int[] helperArray, int left, int right) {
		if (left >= right) return;

		int mid = left + (right - left) / 2;
		mergeSortHelper(array, helperArray, left, mid);
		mergeSortHelper(array, helperArray, mid + 1, right);
		merge(array, helperArray, left, mid, right);
	}

	private void merge(int[] array, int[] helperArray, int left, int mid, int right) {
		
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