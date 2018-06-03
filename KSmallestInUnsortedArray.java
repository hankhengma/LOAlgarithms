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

/**************Quick Selection Method***************

public class Solution {
	public Integer kthSmallest(int[] array, int k) {
		if (array == null || array.length == 0 || k == 0) {
			return null;
		}
		
		quickSelect(array, 0, array.length - 1, k - 1);
		return array[k-1];
	}
	
	private void quickSelect(int[] array, int left, int right, int target) {
		// sort first k eles first and find out the pivot pos;
		int mid = partition(array, left, right);
		
		if (mid == target) {
			return;
		} else if (mid > target) {
			quickSelect(array, left, mid - 1, target);
		} else {
			quickSelect(array, mid + 1, right, target);
		}
	}
	
	private int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int start = left;
		int end = right - 1;
		
		while (start <= end) {
			if (array[start] < pivot) {
				start++;
			} else if (array[end] >= pivot) {
				end--;
			} else {
				swap(array, start++, end--);
			}
		}
		swap(array, start, right);
		return start;
		
	}
	
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}

******************************/

/************minHeap method******************
public int kthSmallest(int[] array, int k) {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
		@Override
		public int compare(Integer n1, Integer n2) {
			if (n1.equals(n2)) {
				return 0;
			}
			return n1 < n2 ? -1 : 1;
		}
	});
	
	minHeap.offer(array[0]);
	
	for (int i = 0; i < array.length; i++) {
		int cur = minHeap.poll();
		if (array[i] < cur) {
			minHeap.offer(array[i]);
		}
	}
	int[] result = new int[k];
	for (int i = 0; i < k; i++) {
		result[i] = minHeap.poll();
	}
	return result[k-1];
}
****************************/