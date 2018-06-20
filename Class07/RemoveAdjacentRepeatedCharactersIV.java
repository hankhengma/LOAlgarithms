public class Solution {
	public String deDup(String input) {
		if (input == null || input.length() < 2) {
			return input;
		}
		StringBuilder result = new StringBuilder();
		char[] array = input.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		int cur = 0;

		while (cur < array.length) {
			if (stack.isEmpty() || array[cur] != stack.peek()) {
				stack.push(array[cur]);
			} else {
				while (cur + 1 < array.length && array[cur+1] != stack.peek()) {
					cur++;
				}
			}
		}

		
		for (int i = 0; i < stack.size(); i++) {
			result.append(stack.pop());
		}

		return result.toString();
	}

	public String deDupI(String input) {
		if (input == null || input.length() < 2) {
			return input;
		}
		
		char[] array = input.toCharArray();
		int cur = 1;
		int prev = 0;

		while (cur < array.length) {
			if (prev == -1 || array[cur] != array[prev]) {
				array[++prev] = array[cur++];
			} else {
				while (cur < array.length && array[cur] == array[prev]) {
					cur++;
				}
				prev--;
			}
		}
		return new String(array, 0, prev + 1);
	}
}
// if stack.peek() == array[cur] -> cur keeps going until array[cur] != stack.peek();
// if stack.peek() != array[cur] -> stack.push(array[cur]);