public class Solution {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		char[] inputArray = input.toCharArray();
		int slow = 0;
		int fast = 1;

		while (fast < inputArray.length) {
			if (inputArray[slow] == inputArray[fast]) {
				fast++;
			} else {
				swap(inputArray, ++slow, fast++);
			}
		}
		return new String(array, 0, slow + 1);
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}