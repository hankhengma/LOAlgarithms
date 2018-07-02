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
}