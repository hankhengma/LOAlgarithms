// time: O(m * n)
// space: O(m * n);
public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		// best first search.
		// data structure: priority queue
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}

				return o1 < o2 ? -1 : 1;
			}
		});

		// the generated nodes cannot be generated again.
		boolean[][] visited = new boolean[rows][cols];
		// offer the 1st cell into the heap;
		minHeap.offer(new Cell(0, 0, matrix[0][0]));

		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();

			if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visited[cur.row + 1][cur.col] = true;
			}

			if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visited[cur.row][cur.col + 1] = true;	
			}
		}
		return minHeap.poll().value;
	}

}

class Cell {
	int row;
	int col;
	int value;

	Cell(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}
}