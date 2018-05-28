public class Solution {
	public int search(Dictionary dic, int target) {
		if (dic == null) {
			return -1;
		}

		int left = 0;
		int right = 1;
		while (dic.get(right) != null && dic.get(right) < target) {
			left = right;
			right = 2 * right;
		}
		return binarySearch(dic, target, left, right);
	}

	private void binarySearch(Dictionary dic, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dic.get(mid) != null || dic.get(mid) > target) {
				right = mid - 1;
			} else if (dic.get(mid) < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}