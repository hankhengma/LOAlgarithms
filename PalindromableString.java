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

	public boolean palindromableII(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}

		Map<Character, Integer> countMap = new HashMap<>();
		char[] strArr = str.toCharArray();
		for (Character c : strArr) {
			if (!countMap.containsKey(c)) {
				countMap.put(c, 1);
			} else {
				Interger count = countMap.get(c);
				count += 1;
				countMap.put(c, count);
			}
		}

		int countOdds = 0;
		for (Map.Entry<Character, Integer> entry: countMap.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				countOdds += 1;
			}
		}

		if (countOdds > 1) {
			return false;
		} else {
			return true;
		}
	}
}