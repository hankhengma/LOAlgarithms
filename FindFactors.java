public class FindFactors {
	public List<List<Integer>> findFactors(int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		int digit = 2;
		dfs(target, digit, cur, result);
		return result;
	}

	private void dfs(int target, int digit, List<Integer> cur, List<List<Integer>> result) {
		if (target == 1 && cur.size() > 0) {
			result.add(new ArrayList<>(cur));
			return;
		}

		for (int i = digit; i <= target; i++) {
			if (target % i == 0) {
				cur.add(i);
				dfs(target / i, i, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
