public class LongestCommonSubstring {
	public String common(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length == 0) {
			return null;
		}

		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		int[][] common = new int[s1Array.length][s2Array.length];
		int commonEnd = 0;
		int longest = 0;
		for (int start = 0; start < s1Array.length; start++) {
			for (int end = 0; end < s2Array.length; end++) {
				if (s1Array[start] == s1Array[end]) {
					if (start == 0 || end == 0) {
						common[start][end] = 1;
					} else {
						common[start][end] = common[start - 1][end - 1] + 1;
					}
					
				}
				if (longest < common[start][end]) {
					longest = common[start][end];
					commonEnd = start;
				}
			}
		}
		return s1.substring(commonEnd - longest + 1, commonEnd + 1);
	}
}