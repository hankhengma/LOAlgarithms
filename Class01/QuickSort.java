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

	private void quickSortHelper(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		
		int pivotIndex = findPivot(array, left, right);
		quickSortHelper(array, left, pivotIndex - 1);
		quickSortHelper(array, pivotIndex + 1, right);		
	}

	private int findPivot(int[] array, int left, int right) {
		int pivotIndex = (int)Math.random() * (right - left + 1) + left;
		int pivot = array[pivotIndex];
		int start = left;
		int end = right - 1;

		while (start <= end) {
			if (array[start] < pivot) {
				++start;
			} else if (array[end] >= pivot) {
				--end;
			} else {
				swap(array, start++, end--);
			}
		}
		swap(array, start, right);
		return start;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}