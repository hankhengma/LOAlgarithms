/***************************************************************
Reverse the words in a sentence.

Assumptions

Words are separated by single space

There are no heading or tailing white spaces

Examples

“I love Google” → “Google love I”

Corner Cases

If the given string is null, we do not need to do anything.
*****************************************************************/

public class Solution {
	public String reverseWords(String input) {
		char[] temp = input.toCharArray();
		int left = 0;
		int right = temp.length - 1;
		reverse(temp, left, right);

		int slow = 0;
		int fast = 0;
		while (fast < temp.length) {
			if (temp[fast] == ' ') {
				reverseHelper(temp, slow, fast - 1);
			}	
			slow++;
			fast++;
		}
		return new String(temp);
	}

	private void reverseHelper(char[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		reverseHelper(array, left + 1, right - 1);
		swap(array, left, right);
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[right];
		array[right] = array[left];
		array[left] = temp;
	}
}
