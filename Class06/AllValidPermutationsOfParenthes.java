public class AllValidPermutationsofParenthes {
	// when using charArray LaiCode will throw errors.
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

	public List<String> validParenthesesI(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int left = n;
		int right = n;
		validParenthesesIHelper(sb, left, right, result);
		return result;
	}

	private void validParenthesesIHelper(StringBuilder sb, int left, int right, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(sb.toString);
			return;
		}

		if (left > 0) {
			sb.append('(');
			validParenthesesIHelper(sb, left - 1, right, result);
			sb.deleteCharAt(sb.lenght() - 1);
		}

		if (right > left) {
			sb.append(')');
			validParenthesesIHelper(sb, left, right - 1, result);
			sb.deleteCharAt(sb.lenght() - 1);	
		}
	}	
}