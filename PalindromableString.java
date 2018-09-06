//PalindromableString.java

public class PalindromableString {
	public boolean palindromable(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int[] countMap = new int[26];
		char[] sArr = s.toCharArray();

		for (int i = 0; i < sArr.length; ++i) {
			countMap[sArr[i] - 'a']++;
		}

		int odd = 0;

		for (int i = 0; i < 26; i++) {
			if (countMap[i] % 2 == 1) {
				++odd;
			}
		}
		if (odd > 1) {
			return false;
		} else {
			return true;
		}
	}
}