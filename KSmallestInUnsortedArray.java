// Time: O( + (n-k)logk)
// Space: O(k)

public class Solution{
	public int[] kSmallest(int[] array, int k) {
		if (array.length ==0 || k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 < o2 ? -1 : 1;
			}
		});

		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				// put first K elements into the heap
				minHeap.offer(array[i]);
			} else if (array[i] < minHeap.peek()) {
				// if the array[i] < min value in the minHeap. update minHeap.
				minHeap.poll();
				minHeap.offer(array[i]);
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}
}