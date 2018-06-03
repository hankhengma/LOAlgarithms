public class Solution {
	public String removeSpaces(String input) {
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;

		while (fast < array.length) {
			if (array[fast] == ' ' && fast == 0 || array[fast - 1] == ' ') {
				fast++;
			} else {
				array[slow++] = array[fast++];
			}
		}

		// if (array[fast] == ' ') {
		// 	return new String(array, 0, slow);
		// } else {
		// 	return new String(array, 0, fast);
		// }
		if (slow > 0 && array[slow - 1] == ' ') {
			slow--;
		}
		return new String(array, 0, slow);
	}
}

// _I__love___yahoo_
// ->
// I_Love_yahoo
// data structure: two pointers:
// slow : the left of slow pointer (not included) is the result I wanna keep
// fast: the fast pointer is pointing at the character under determing.