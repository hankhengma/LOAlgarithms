public class LongestCommonSubsequence {
	public Set<Character> commonSubsequence(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return null;
		}

		int[][] m = new int[s1.length() + 1][s2.length() + 1];
		Set<Character> set = new HashSet<>();
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					m[i][j] = m[i - 1][j - 1] + 1;
					set.add(s1.charAt(i - 1));
				}
				else {
					m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]);
				}
			}
		}
		return set;
	}
}

/**************
student
sweden
11
sden

	0 1 2 3 4 5 6
      s t u d e n t
    0 0 0 0 0 0 0 
0 s 1 1 1 1 1 1 1 
1 w 1 1 1 1 1 1 1
2 e 1 1 1 1 2 2 2
3 d 2 2 2 2 2 2 2
4 e 2 2 
5 n 

s t u d e
s w e d e

1 1 1 1 1 1 1
1 

m[3][5] = 2 





	0 1 2 3 4 5 6
    s t u d e n t
0 s 1 0 0 0 0 0 0
1 w 0 0 0 0 0 0 0
2 e 0 0 0 0 1 0 0
3 d 0 0 0 1 0 0 0
4 e 0 0 0 0 2 0 0
5 n 0 0 0 0 0 3 0

base case:
m[0][0] = 0;
m[i][0] = 0;
m[0][j] = 0;

induction rule:

if a[i] == b[j] m[i][j] = m[i - 1][j - 1] + 1;
	a[i] != b[j] m[i][j] = max(m[]);

	1 2 3 4 5
	a b c d e
1 c 0 0 1 1 1
2 b 
3 a 
4 b
5 d
6 f
7 e

