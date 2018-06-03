// find all permutation of a string containing duplicate letters.
public class AllPermutaionII {
	public List<String> permutation(String input) {
		List<String> result = new ArrayList<>();
		if (input == null || inpurt.isEmpty()) {
			return result;
		}

		char[] array = input.toCharArray();
		int cur = 0;
		
		permutation(array, cur, visited, result);
		return result;
	}

	private void permutation(char[] array, int cur, List<String> result) {
		if (cur >= array.length - 1) {
			result.add(Arrays.toString(array));
			return;
		}
		// set is created inside the recursion
		// because it is just recording
		// distinct elements in current level
		Set<Character> visited = new HashSet<>();
		for (int i = cur; i < array.length; ++i) {
			if (visited.add(array[cur])) {
				swap(array, cur, i);
				permutation(array, cur + 1, result);
				swap(array, cur, i);
			}
		}
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}