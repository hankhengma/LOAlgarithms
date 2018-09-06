/**********
Time: O(nlogn)
Space: O(1)
*********/

public class Solution {
	public int[] quickSort(int[] array) {
		int n = array.length;
		if (n == 0 || array == null) {
			return array;
		}

		quickSortHelper(array, 0, n - 1);
		return array;
	}

	public void quickSortHelper(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		int leftStart = left, rightStart = right - 1;
		// int pivotIndex = (int)(Math.random()*(right - left + 1));
		int pivotIndex = right;
		int pivot = array[pivotIndex];
		// swap(array, pivotIndex, right);

		while (leftStart <= rightStart) {
			if (array[leftStart] < pivot) {
				leftStart++;
			}
			else if (array[rightStart] >= pivot) {
				rightStart--;
			}
			else {
				swap(array, leftStart++, rightStart--);
			}
		}

		swap(array, leftStart, pivotIndex);

		quickSortHelper(array, left, leftStart - 1);
		quickSortHelper(array, leftStart + 1, right);
		
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}