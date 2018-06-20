public class Solution {
	public String hex(int number) {
		char[] charMap = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

		StringBuilder sb = new StringBuilder();
		// binary -> hexi
		// every 4 bits;
		sb.append("0x");
		for (int i = 28; i >= 0; i -= 4) {
			char bit = charMap[(number >> i) & 0xF];
			sb.append(bit);
		}
		return sb.toString();
	}
}