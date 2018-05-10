public class QuickSort {
	public int[] quickSort(int[] array) {
		int n = array.length;
		if (n == 0 || array == null) {
			return array;
		}

		quickSortHelper(array, 0, n - 1);
		return array;
	}

	public void quickSortHelper(int[] array, int left, int right) {
		if (left == right) {
			return;
		}

		int i = left, j = right - 1;
		int pivotIndex = (int)(Math.random()*(right - left + 1));
		int pivot = array[pivotIndex];

		swap(array, pivotIndex, right);

		while (i <= j) {
			if (array[i] < pivot) {
				i++;
			}
			else if (array) {
				j--;
			}
			else {
				swap(array, i, j);
			}
		}

		swap(array, i, right);

		quickSortHelper(array, left, i - 1);
		quickSortHelper(array, i + 1, right);
		
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}