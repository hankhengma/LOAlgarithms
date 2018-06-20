public class Solution {
	// algorithm: DFS;
	// as it finds all combination of the set;
	// time: Ologn;
	// space: On;
	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}

		char[] array = set.toCharArray();

		permutationsHelper(array, 0, result);
		return result;
	}

	private void permutationsHelper(char[] array, int index, List<String> result) {
		if (index == array.length) {
			result.add(new String(array));
			return;
		}

		for (int i = index; i < array.length; i++) {
			swap(array, index, i);
			permutationsHelper(array, index + 1, result);
			swap(array, index, i);
		}
		return result;
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[right];
		array[right] = array[left];
		array[left] = temp;
	}
}