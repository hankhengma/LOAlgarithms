import java.util.*;

public class AllSubSetsII {
	public List<String> subsets(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}

		char[] array = set.toCharArray();
		int cur = 0;
		Set<String> visited = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		subsetsHelper(array, sb, cur, visited, result);
		return result;

	}

	private void subsetsHelper(char[] array, StringBuilder sb, int cur, Set<String> visited, List<String> result) {
		if (cur == array.length) {
			if (visited.contains(sb.toString())) {
				result.add(sb.toString());
				return;
			}
		}
		subsetsHelper(array, sb, cur + 1, visited, result);
		subsetHelper(array, sb.append(array[cur]), cur + 1, visited, result);
		sb.deleteCharAt(sb.length() - 1);
	}
}