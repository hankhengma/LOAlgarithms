public class AllValidPermutationsofParenthes {
	public List<String> validParentheses(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0) {
			return result.add(new String());
		}

		char[] array = new char[n * 2];
		int left = n;
		int right = n;
		int index = 0;

		validParenthesesHelper(array,left,right,index,result);

		return result;
	}

	private void validParenthesesHelper(char[] array, int left, int right, int index, List<String> result) {
		if (index >= array.length) {
			result.add(array.toString());
			return;
		}
		
		if (left > 0) {
			array[index] = '(';
			validParenthesesHelper(array, left - 1, right, index + 1, result);
		}

		if (right > left) {
			array[index] = ')';
			validParenthesesHelper(array, left, right - 1, index + 1, result);	
		}
	}
}