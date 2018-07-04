/********************************************************************************
Given a string, a partitioning of the string is a palindrome partitioning
if every substring of the partition is a palindrome. 
Determine the fewest cuts needed for a palindrome partitioning of a given string.
*********************************************************************************/

public class MinimumCutsForPalindromes {
	public int minCut(String input) {
		if (input == null || input < 2) {
			return 0;
		}
		char[] inputArray = input.toCharArray();
		int length = input.length();
		int[] minCut = new int[length + 1];
		boolean isPalindrome = new boolean[length + 1][length + 1];

		for (int end = 1; end <= length; end++) {
			minCut[end] = end;
			for (int start = end; start >= 1; start--) {
				if (inputArray[start - 1] == inputArray[end - 1]) {
					isPalindrome[start][end] = end - start < 2 || isPalindrome[start + 1][end - 1];
				}
				if (isPalindrome[start][end]) {
					minCut[end] = Math.min(minCut[end], minCut[start - 1] + 1);
				}
			}
		}
		return minCut[length] - 1;
	}
}