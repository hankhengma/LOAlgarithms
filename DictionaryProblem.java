public class DictionaryProblem {
/***********************************************************
	dictonary: {bob, rob, cat};
	word1: bcoabt
	word2: bobcatrob
	base case: m[0] = false;
		m[1] = 'b' --> false;
		m[2] = "bo" --> false;
			case 1. 'b' | 'o'
				OR
			case 2. "bo";
		m[3] == "bob"
			case 1: "bo" | 'b'
				OR
			case 2: 'b' | "bo"
				OR
			case 3: "bob"
	induction rule:
		m[i] --> no cut
				OR
			--> m[i-1] && m[substring(j,i)]
**********************************************************/
	public boolean isComposedIII(String word, List<String> dictionary) {
		if (word == null || dictionary == null || word.isEmpty() || dictionary.isEmpty()) {
			return null;
		}
		Set<String> hashset = new HashSet<>().addAll(dictionary);
		boolean[] composed = new boolean[word.length() + 1];

		for (int i = 1; i <= word.length(); i++) {
			// No cut;
			if (hashset.contains(word.substring(0,i))) {
				composed[i] = true;
			}

			for (int j = 1; j < i; j++) {
				if (composed[j] && hashset.contains(word.substring(j, i))) {
					m[i] = true;
					break;
				}
			}
		}
		return composed(word.length());
	}
	// unverified
	public boolean isComposedI(String words, List<String> dictionary) {
		
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

	// Verified but can be optimized
	public boolean isComposedII(String words, List<String> dictionary) {
		
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
			for (int j = 0; j < i; j++) {
				composed = canBeComposed[i] && canBeComposed[j];
			}
		}
		return composed;
	}
}