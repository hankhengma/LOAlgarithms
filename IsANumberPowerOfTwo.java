public class Solution {
	public boolean isPower(int num) {
		// is the power of 2
		// need to count how many "1" the number has
		// after transfering to binary.
		int count = 0;

		while (num > 0) {
			if (num&1 == 1) {
				count++;
			}
			num >>= 1;
		}
		return count == 1 ? true : false;
	}
}