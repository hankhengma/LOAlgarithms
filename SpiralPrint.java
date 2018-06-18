public class SpiralPrint {
	public List<Integer> spiralPrint(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<>();
		int size = matrix.length;
		int offset = 0;
		int counter = 0
		spiralPrintHelper(matrix, size, offset, result);
		return result;
	}

	private void spiralPrintHelper(int[][] matrix, int size, int offset, int counter, List<Integer> result) {
		int len = matrix.length;
		if (size <= 1) {
			if (size == 1) {
				result.add(matrix[0 + offset][0 + offset]);
			}
			return;
		}
		// top
		for (int i = 0; i < len - 1 - counter; i++) {
			result.add(matrix[0 + offset][i + offset]);
		}
		// right
		for (int i = 0; i < len - 1 - counter; i++) {
			result.add(matrix[i + offset][len - 1 - offset]);
		}
		// bottom
		for (int i = 0; i < len - 1 - counter; i++) {
			result.add(matrix[len - 1 - offset][len - 1 - i - offset]);
		}
		// left
		for (int i = 0; i < len - 1 - counter; i++) {
			result.add(matrix[len - 1 - i - offset][0 + offset]);
		}

		spiralPrintHelper(matrix, size - 2, offset + 1, counter + 2, result);
	}
}