public class Solution {
	public String replace(String text, String pattern, String replace) {
		// case1: pattern.length >= replacement.length;
		// two pointers:
		// 1. fast: the ele is under processing.
		// 2. slow: the left of slow are the ele has been processed and kept.
		if (text == null || text.length() == 0 || text.length < pattern.length) {
			throw new Exception("the original text is not available.");
		}
		char[] array = text.toCharArray();
		// case 1: pattern.length >= replace.length;
		if (pattern.length >= replace.length) {
			return replaceShorter(array, pattern, replace);
		}
		// case2: pattern.length < replace.length;
		return replaceLonger(array, pattern, replace);
	}

	public String replaceShorter(char[] input, String p, String r) {
		int slow = 0;
		int fast = 0;

		while (fast < input.length) {
			// input[fast] == p.charAt[0] && input[fast, fast + p.length() - 1] == p. 
			if (fast <= input.length - p.length() && subEquals(input, fast, p)) {
				copySubstring(input, slow, r);
				slow += r.length();
				fast += p.length();
			} else {
				input[slow++] = input[fast++];
			}
		}
		return new String(input[0, slow]);
	}

	public String replaceLonger(char[] input, String p, String r) {
		// 1. need to calculate all the extra space we need:
		// 	find out all the matches. resize the array. slow is at the end of the new array
		// 	fast is at the end of the old array;
		List<Integer> allMatches = allMatches(input, p);
		int newSize = input.length + allMatches.size() * (r.length() - p.length());
		char[] newArray = new char[newSize];
		int lastIndex = allMatches.size() - 1;
		int slow = newArray.length - 1;
		int fast = input.length - 1;

		while (fast >= 0) {
			if (lastIndex >= 0 && fast = allMatches.get(lastIndex)) {
				copySubstring(input, slow - p.length() + 1, r);
			} else {
				newArray[slow--] = input[fast--];
			}
		}

	}

	private boolean subEquals(char[] input, int index, String p ) {
		for (int i = 0; i < p.length(); i++) {
			if (input[index + i] != p.charAt(i)) {
				return false;
			}
		}	
		return true;
	}

	private void copySubstring(char[] input, int index, String r) {
		for (int i = 0; i < r.length(); i++) {
			input[index + i] = r.charAt(i);
		}
	}

	private List<Integer> allMatches(char[] input, String p) {
		List<Integer> matches = new ArrayList<>();

		int i = 0;
		while (i <= input.length - p.length()) {
			if (subEquals(input, i, p)) {
				matches.add(i + p.length() - 1);
				i += p.length();
			} else {
				i++;
			}
		}
		return matches;
	}
}
