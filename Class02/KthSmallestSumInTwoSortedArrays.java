class Cell {
	int row;
	int col;
	int sum;
	Cell(int row, int col, int sum) {
		this.row = row;
		this.col = col;
		this.sum = sum;
	}
}

public class Solution {
	public int kthSmallestSum(int[] a, int[] b, int k) {
		// we assume array a and array b are not null or blank;
		int rows = b.length;
		int cols = a.length;
		boolean[][] visited = new boolean[rows][cols];
		// Initialization
		// PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
		// 	@Override
		// 	public int compare(Cell c1, Cell c2) {
		// 		if (c1.sum == c2.sum) {
		// 			return 0;
		// 		}
		// 		return c1.sum > c2.sum ? -1 : 1;
		// 	}
		// });
		// change maxHeap to minHeap as need to store k cells into the heap first
		// then check any another cells' value larger or smaller than the heapPeak.
		// which is very hard to implement;

		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.sum == c2.sum) {
					return 0;
				}
				return c1.sum < c2.sum ? -1 : 1;
			}
		});
		minHeap.offer(new Cell(0, 0, a[0] + b[0]));
		visited[0][0] = true;

		// Logic part
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, a[cur.col] + b[cur.row + 1]));
				visited[cur.row + 1][cur.col] = true;
			}

			if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, a[cur.col + 1] + b[cur.row]));
				visited[cur.row][cur.col + 1] = true;	
			}
		}
		return minHeap.poll().sum;
	}
}