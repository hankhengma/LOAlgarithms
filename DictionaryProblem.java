public class DictionaryProblem {
	// dictonary: {bob, rob, cat};
	// word1: bcoabt
	// word2: bobcatrob
	// base case: m[0] = false;
		// m[1] = false;
		// m[2] = false;
		// m[3] --> need to check dictionary;
		// m[4] = false; the lenght isn't correct;
	// Induction rule:
		// m[i] = m[i-3] && current three letters;
	public boolean isComposedI(String words, List<String> dictionary) {
		// unverified
		if (words == null) {
			return false;
		}
		Set<String> hashset = new HashSet<>();
		for (String dic : dictionary) {
			hashset.add(dic);
		}
		int wordsLength = words.length();
		char[] array = words.toCharArray();
		boolean[] canBeComposed = new boolean[wordsLength];
		canBeComposed[0] = false;
		canBeComposed[1] = false;
		for (int i = 2; i < wordsLength; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(array, i, 3);
			canBeComposed[i] = hashset.contains(sb.toString()) && canBeComposed[i - 1];
		}
		return canBeComposed[wordsLength - 1];
	}

	public boolean isComposedII(String words, List<String> dictionary) {
		// Verified but can be optimized
		Set<String> hashset = new HashSet<>();
		for (String word : dictionary) {
			hashset.add(word);
		}
		
		if (words == null || words.isEmpty() || words.length() % 3 != 0) {
			return false;
		}
		char[] array = words.toCharArray();
		boolean[] canBeComposed = new boolean[words.length() / 3];
		boolean composed = false;
		
		int end = words.length() / 3;
		for (int i = 0; i < end; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(array, i*3, 3);
			canBeComposed[i] = hashset.contains(sb.toString());
			composed = canBeComposed[i];
//			composed = hashset.contains(sb.toString());
			for (int j = 0; j < i; j++) {
				composed = canBeComposed[i] && canBeComposed[j];
//				composed = composed && canBeComposed[j];
			}
		}
		return composed;
	}

}