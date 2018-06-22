public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		// assumption: input != null && pattern != null
		char[] inputArray = input.toCharArray();
		char[] patternArray = patter.toCharArray();
		int inputIndex = 0;
		int patternIndex = 0;
		return matchHelper(inputArray, patternArray, inputIndex, patternIndex);
	}

	private boolean matchHelper(char[] inputArray, char[] patternArray, int inputIndex, int patternIndex) {
		// base case
		if (inputIndex == inputArray.length && patternIndex == patternArray.length) {
			return true;
		} else (inputIndex == inputArray.length || patternIndex == patternArray.length) {
			return false;
		}

		if (isLetter(patternArray[patternIndex])) {
			if (inputArray[inputIndex] != patternArray[patternIndex]) {
				return false;
			}
			return matchHelper(inputArray, patternArray, inputIndex + 1, patternIndex + 1);
		} else if (isDigit(patternArray[patternIndex])) {
			int num = 0;
			while (patternIndex < patternArray.length && isDigit(patternArray[patternIndex])) {
				num = num * 10 + (patternArray[patternIndex] - '0');
				patternIndex++;
			}

			if (inputIndex + num > inputArray.length) {
				return false;
			}
			return matchHelper(inputArray, patternArray, inputIndex + num, patternIndex);
		}
		return false;
	}
	private boolean isLetter(char c) {
		return (c - 'a' >= 0 && c - 'z' <= 0) || (c - 'A' >= 0 && c - 'Z' <= 0);
	}
	private boolean isDigit(char c) {
		return c - '0' >= 0 && c - '9' <= 0;
	}
}