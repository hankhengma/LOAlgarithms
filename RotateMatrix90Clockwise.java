public class RotateMatrix90Clockwise {
	public void rotate(int[][] matrix) {
		// assumption: matrix is not null;
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		int round = n / 2;
		for (int level = 0; level < roud; level++) {
			int left = level;
			int right = n - 1 - left;
			for (int i = left; i < right; i++) {
				int temp = matrix[left][i];
				matrix[left][i] = matrix[n - 1 - i][left];
				matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
				matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
				matrix[i][n - 1 - left] = temp;
			}
		}
	}
}
