public class Solution {
	public List<String> validParentheses(int n) {
		List<String> result = new ArrayList<>();
		char[] cur = new char[n * 2];
		helper(cur, n, n, 0, result);
		return result;
	}

	private void helper(char[] array, int left, int right, int index, List<String> result) {
		if (left == 0 && left == 0) {
			result.add(new String(array));
			return;
		}

		if (left > 0) {
			array[index] = '(';
			helper(array, left - 1, right, index + 1, result);
		}
		if (right > left) {
			array[index] = ')';
			helper(array, left, right - 1, index + 1, result);	
		}
	}
}