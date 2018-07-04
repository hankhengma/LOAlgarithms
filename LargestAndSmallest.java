public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}

		int len = array.length;
		int start = 0;
		int end = len - 1;
		int[] small = new int[len / 2 + 1];
		int[] large = new int[len / 2 + 1];
		int i = 0;
		while (start <= end) {
			if (array[start] <= array[end]) {
				small[i] = array[start++];
				large[i] = array[end--];
			} else {
				large[i] = array[start++];
				small[i] = array[end--];
			}
		}

		int globalSmall = Integer.MAX_VALUE;
		int globalLarge = Integer.MIN_VALUE;
		
		for (int i = 0; i < small.length; i++) {
			if(small[i] < globalSmall) {
				globalSmall = small[i];
			}
		}

		for (int i = 0; i < large.length; i++) {
			if(large[i] > globalSmall) {
				globalLarge = large[i];
			}
		}
		return new int[]{globalSmall, globalLarge};
	}

	public int[] largestAndSmallestI(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int len = array.length;
		for (int i = 0; i < len / 2; i++) {
			if (array[i] > array[len - 1 -i]) {
				swap(array, i, len - 1 - i);
			}
		}
		return new int[]{smallest(array, 0, (len - 1) / 2), largest(array, len / 2, len - 1)};
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private int largest(int[] array, int start, int end) {
		int globalLargest = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			globalLargest = globalLargest > array[i] ? globalLargest : array[i];
		}
		return globalLargest;
	}

	private int smallest(int[] array, int start, int end) {
		int globalSmallest = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			globalSmallest = globalSmallest < array[i] ? globalSmallest : array[i];
		}
		return globalSmallest;
	}
}