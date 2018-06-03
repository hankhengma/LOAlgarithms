public class Solution {
	public boolean allUnique(String word) {
		// assume input != null;
		char[] wordArray = word.toCharArray();

		Set<Character> charSet = new HashSet<>();

		for (Character c : wordArray) {
			if (charSet.contains(c)) {
				return false;
			}
			charSet.add(c);
		}
		return true;
	}
	// bit operation
	// there are 256 characters in total;
	// 
	public boolean allUniqueI(String word) {
		char[] wordArray = word.toCharArray();
		// 256 / 32 = 8;
		int[] bit_array = new int[8];

		for (char c : wordArray) {
			int row = c / 32;
			int col = c % 32;

			if (((bit_array[row] >> col) & 1) == 1) {
				return false;
			}

			bit_array[row] |= (1 << col);
		}
		return true;
	}
}