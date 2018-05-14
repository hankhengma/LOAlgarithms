public class MyHeap {
	private int size;
	private int[] array;

	public MyHeap(int[] array) {
		size = array.length;
		this.array = array;
		heapify();
	}

	public MyHeap(int capacity) {
		array = new int[capacity];
		size = 0;
	}

	public void heapify() {
		for(i = size / 2 - 1; i >= 0; i++) {
			perculateDown(i);
		}
	}

	public void perculateUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[index] < array[parentIndex]) {
				swap(array, index, parentIndex);
			} else {
				break;
			}
			index = parentIndex;
		}
	}

	public void perculateDown(int index) {
		while (index <= size / 2 - 1) {
			int leftIndex = index * 2 + 1;
			int rightIndex = index * 2 + 2;
			// int candidate = rightIndex;
			// initialized the candidate to leftIndex in case of the parent node doesn't have right child or right child is out bound;
			int candidate = leftIndex;

			// if (rightIndex >= size) {
			// 	candidate = leftIndex;
			// }

			// update candidate if the rightIndex is inbound and < array[leftIndex];
			if (rightIndex <= size - 1 && array[rightIndex] < array[leftIndex]) {
				candidate = rightIndex;
			}

			if (array[index] > array[candidate]) {
				swap(array, index, candidate);
			} else {
				break;
			}
			index = candidate;
		}
	}

	public int poll() {
		if (size == 0) {
			throw new Exception("Heap is empty");
		}
		int top = array[0];
		swap(array, 0, size - 1);
		size -= 1;
		perculateDown(0);
		return top;

	}

	public int offer(int target) {
		if (size == array.length) {
			int[] newArray = new int[array.length * 1.5];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;	
		}
		array[size] = target;
		size += 1;
		perculateUp(size - 1);
	}
	// return the original value
	public int update(int index, int target) {
		int result = array[index];
		array[index] = target;
		if (target > result) {
			perculateDown(index);
		} else {
			perculateUp(index);
		}
		return result;

	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}