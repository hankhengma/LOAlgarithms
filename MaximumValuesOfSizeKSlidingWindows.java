public class MaximumValuesOfSizeKSlidingWindows {
	public List<Integer> maxWindows(int[] array, int k) {
		if (k.length == 0 || k < 1) {
			return null;
		}

		List<Integer> result = new ArrayList<>();
		//store the index;
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < array.length; i++) {
			while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		return result;
	}
}


/************************
0 1 2 3 4 5 6 7 8
1 3 2 5 8 9 4 7 3
-----
{(7,7), (3,8)}

3, 5, 8, 9 , 9, 9 7,


{(7,7) (3,8)}