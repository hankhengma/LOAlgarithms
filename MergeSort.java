public class MySort {
	public static int[] selectionSort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}

		for (int i = 0; i < array.length - 1; i++) {
			int globalMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[globalMin]) {
					globalMin = j;
				}
			}
			swap(array, globalMin, j);
		}
		return array;
	}

	private static void swap(int[] array, int a, int b) {
		int temp;
		temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}

	public static int[] mergeSort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}

		mergeSortHelper(array, 0, array.length - 1);
		return array;
	}

	private static void mergeSortHelper(int[] array, int left, int right) {
		if (left >= right) return;

		int mid = left + (right - left) / 2;
		mergeSortHelper(array, left, mid);
		mergeSortHelper(array, mid + 1; right);
		merge(array, left, mid, right);
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int[] temp = new int[array.length];
		for (int i = left; i <= right; i++) {
			temp[i] = array[i];
		}

		int leftIndexOfTemp = left;
		int rightIndexOfTemp = mid + 1;

		while (leftIndexOfTemp <= mid && rightIndexOfTemp <= right) {
			if (temp[leftIndexOfTemp] <= temp[rightIndexOfTemp]) {
				array[left++] = temp[leftIndexOfTemp++];
			}
			else {
				array[left++] = temp[rightIndexOfTemp];
			}
		}
		while (leftIndexOfTemp <= mid) {
			array[left++] = temp[leftIndexOfTemp];
		}
	}
}