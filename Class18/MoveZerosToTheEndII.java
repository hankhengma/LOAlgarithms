// Data Structure:
// slow: the left part of the slow (ex) is the non-0s;
// fast: the ele is under processing;
// 
// Algorithm:
// if non-zero then copy to the left of slow;
// else rightIndex++;
// 
public class MoveZerosToTheEndII {
	// the quick sort doesn't work as we need to maintain the order;
	// public int[] move0s(int[] array) {
	// 	if (array == null || array.length == 0) {
	// 		return array;
	// 	}

	// 	int len = array.length;
	// 	int leftIndex = 0;
	// 	int rightIndex = len - 1;

	// 	while (leftIndex <= rightIndex) {
	// 		if (array[leftIndex] != 0) {
	// 			leftIndex++;
	// 		} else if (array[rightIndex] == 0) {
	// 			rightIndex--;
	// 		} else {
	// 			swap(array, leftIndex++, rightIndex++);
	// 		}
	// 	}
	// 	return array;
	// }
	public int[] move0s(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int slow = 0;
		int fast = 0;
		int len = array.length;

		while (fast < len) {
			if (array[fast] == 0) {
				fast++;
			} else {
				swap(array, slow++, fast++);
			}
		}
		return array;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}