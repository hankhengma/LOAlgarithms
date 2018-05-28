public class Solution {
	public List<String> subSets(String set) {
		// No Duplicates
		List<String> result = new ArrayList<>();

		if (set == null) {
			return result;
		}

		char[] array = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		sebSetHelper(array, sb, 0, result);
		return result;
	}

	private void sebSetHelper(char[] array, StringBuilder sb, int index, List<String> result) {
		if (index == array.length) {
			result.add(sb.toString());
			return;
		}

		sebSetHelper(array, sb.append(array[index]), index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		sebSetHelper(array, sb., index + 1, result);
	}
}