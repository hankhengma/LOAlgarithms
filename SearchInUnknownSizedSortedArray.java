public class SearchInUnknownSizedSortedArray {
	public int search(dicttionary dict, int target) {
		int left = 0;
		int right = findBound(dict, left, target);

		if (right == -1) {
			return -1;
		}

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (dict.get(mid) == target) {
				return mid;
			} else if (dict.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;

	}

	private int findBound(dicttionary dict, int index, int target) {
		if(dict.get(index) == null) {
			return -1;
		}

		while (dict.get(index) < target) {
			index += 1;
		}
		return index;
	}
}