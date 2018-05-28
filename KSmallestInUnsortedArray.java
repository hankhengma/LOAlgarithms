// Time: O(k + (n-k)logk)
// Space: O(k)

public class Solution{
	public int[] kSmallest(int[] array, int k) {
		if (array.length ==0 || k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value.equals(o2.value)) {
					return 0;
				}
				return o1.value > o2.value ? -1 : 1;
			}
		});

		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				// put first K elements into the heap
				maxHeap.offer(array[i]);
			} else if (array[i] < maxHeap.peek()) {
				// if the array[i] < min value in the maxHeap. update maxHeap.
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}
		return result;
	}
}