public class Solution {
	public String rightShift(String input, int n) {
		if (input.length() <= 1) {
			return input;
		}

		char[] array = input.toCharArray();

		// find how many letters left in the string at the end;
		n %= array.length;

		reverseHelper(array, array.length - n, array.length - 1);
		reverseHelper(array, 0, array.length - n - 1);
		reverseHelper(array, 0, array.length - 1);
		
		return new String(array);
	}

	private void reverseHelper(char[] array, int left, int right) {
		while (left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}