public class Solution {
	public intp[] search(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[]{-1, -1};
		}
		int rows = matrix[0].length;
		int cols = matrix.length;
		int left = 0;
		int right = rows * cols - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			int row = mid / cols;
			int col = mid % cols;

			if (matrix[row][col] == target) {
				return new int[]{row, col};
			} else if (matrix[row][col] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return new int[]{-1, -1};
	}
}