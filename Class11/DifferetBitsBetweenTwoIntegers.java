public class Solution {
	public int diff(int n1, int n2) {
		int c = n1 ^ n2;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((c & 1) == 1) {
				count++;
			}
			c >>= 1;
		}
		return count;
	}
}