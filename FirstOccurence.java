public class Solution {
	public int firstOccur(int[] array, int target) {
		if (array.length == 0 || array == null) {
			return -1;
		}

		int left = 0, right = array.length - 1;
		// not the exact binary search
		/*******************************************
		while (left <= right) {
			int mid = left + (right - left) + 1;

			if (array[mid] >= target) {
				right--;
			}
			else {
				left++;
			}
		}


		if(array[left] == target) {
			return left;
		}

		if (array[right] == target) {
			return right;
		}
		********************************************/
		// left < right -1 is in case of infinite loop. and keep at least two elements to compare in the array.
		while (left < right - 1) {
			int mid = left + (right - left) / 2;

			if (array[mid] >= target) {
				right = mid;
			}
			else {
				left = mid;
			}
		}

		if (array[left] == target) {
			return left;
		}
		else if (array[right] == target) {
			return right;
		}

		return -1;
	}
}