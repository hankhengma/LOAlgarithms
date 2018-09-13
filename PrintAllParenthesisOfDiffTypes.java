public class Solution {
	// Print all parenthesis with diff kinds ({}[]())
	public List<String> printAll(int k, int m, int n) {
		// k -- pair of {} 
		// m -- pair of []
		// n -- pair of ()
		List<String> res = new ArrayList<>();		
		char[] chars = new char[k * 2 + m * 2 + n * 2];
		int kLeft = k, kRight = k;
		int mLeft = m, mRight = m;
		int nLeft = n, nRight = n;
		int index = 0;
		dfs(chars, kLeft, kRight, mLeft, mRight, nLeft, nRight, index, res);
		return res;
	}

	private void dfs(char[] chars, int kLeft, int kRight, int mLeft, int mRight, int nLeft, int nRight, int index, List<String> res) {
		if (index >= chars.length) {
			res.add(Arrays.toString(chars));
			return;
		}

		if (kLeft > 0 || mLeft > 0 || nLeft > 0) {
			if (kLeft > 0) {
				chars[index] = '{';
				dfs(chars, kLeft - 1, kRight, mLeft, mRight, nLeft, nRight, index + 1, res);
			} else if (mLeft > 0) {
				chars[index] = '[';
				dfs(chars, kLeft, kRight, mLeft - 1, mRight, nLeft, nRight, index + 1, res);
			} else {
				chars[index] = '(';
				dfs(chars, kLeft, kRight, mLeft, mRight, nLeft - 1, nRight, index + 1, res);
			}
		}

		if (kRight > kLeft || mRight > mLeft || nRight > nLeft) {
			if (kRight > kLeft) {
				chars[index] = '}';
				dfs(chars, kLeft, kRight - 1, mLeft, mRight, nLeft, nRight, index + 1, res);
			} else if (mRight > mLeft) {
				chars[index] = ']';
				dfs(chars, kLeft, kRight, mLeft, mRight - 1, nLeft, nRight, index + 1, res);
			} else {
				chars[index] = ')';
				dfs(chars, kLeft, kRight, mLeft, mRight, nLeft, nRight - 1, index + 1, res);
			}
		}
	}
}