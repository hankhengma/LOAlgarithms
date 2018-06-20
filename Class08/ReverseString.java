public class Solution {
	public String reverse(String input) {
		char[] temp = input.toCharArray();
		int left = 0;
		int right = temp.length() - 1;
		reverseHelper(temp, left, right);
		return new String(temp);
	}

	private void reverseHelper(char[] input, int left, int right) {
		if (left >= right) {
			return;
		}
		reverseHelper(input, left + 1, right - 1);
		swap(input, left, right);
	}

	private void swap(char[] input, int left, int right) {
		char temp = input[right];
		input[right] = input[left];
		input[left] = temp;
	}

	public static void main(String[] args) {
		String input = "google";
		String result = new Solution().reverse(input);
		System.out.print(result);
	}
}