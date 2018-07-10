public class LargestRectangleInHistogram {
	public int largestRec(int[] array) {
		// construct a stack to record the longest rec's bottom.
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			// deal with the last element of the array
			// otherwise the last element will be skipped off.
			int cur = i >= array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= array[i]) {
				// the while loop keeps poping the top element of the stack 
				// until the top element of the stack is less than array[i];
				int height = array[stack.pollFirst()];
				// left board determination:
				// if the stack is empty: it means array[i] is smaller than all the elements in the stack;
				// otherwise: it means array[i] is larger than someone in the stack;
				int leftBoard = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, height * (i - left));

			}
			stack.offerFirst(i);
		}
		return result;
	}
}