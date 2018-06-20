import java.util.*;

public class CombinationsOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<>();
		if (coins == null || coins.length == 0 || target == 0) {
			return result;
		}

		List<Integer> curLevel = new ArrayList<>();
		int cur = 0;
		combinationsHelper(target, coins, cur, curLevel, result);
		return result;
	}

	private void combinationsHelper(int target, int[] coins, int cur, List<Integer> curLevel, List<List<Integer>> result) {
		if (cur == coins.length - 1) {
			if (target % coins[cur] == 0) {
				curLevel.add(target / coins[cur]);
				result.add(new ArrayList<Integer>(curLevel));
				curLevel.remove(curLevel.size() - 1);
			}
			return;
		}

		for (int i = 0; i <= target / coins[cur]; i++) {
			curLevel.add(i);
			combinationsHelper(target - coins[cur] * i, coins, cur + 1, curLevel, result);
			curLevel.remove(curLevel.size() - 1);
		}
	}
}