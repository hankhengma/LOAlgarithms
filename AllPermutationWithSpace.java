public class AllPermutationWithSpace {
	public List<String> permutation(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char[] sArray = s.toCharArray();
		int index = 0;

		permutationHelper(sArray, index, sb, result);
		return result;
	}

	private void permutationHelper(char[] sArray, int index, StringBuilder sb, List<String> result) {
		if (index == sArray.length - 1) {
			// post-process
			sb.append(sArray[index]);
			result.add(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return;
		}
		
		sb.append(sArray[index]);
		sb.append('_');
		permutationHelper(sArray, index + 1, sb, result);
		sb.deleteCharAt(sb.length() - 1);

		permutationHelper(sArray, index + 1, sb, result);
		sb.deleteCharAt(sb.length() - 1);	
		
	}
}
// Time: O2^(n-1);
// Space On
