public class LargestRectangleInHistogram {
	public int largestRec(int[] array) {
		// construct a stack to record the longest rec's bottom.
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			while (!stack.isEmpty() && array[stack.top()] >= array[i]) {
				int height = array[stack.top()];
				int leftBoard = stack.pop() + 1;
				result = Math.max(result, height * (i - left));

			}
			stack.add(i);
		}
		return result;
	}
}