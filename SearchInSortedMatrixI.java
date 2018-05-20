/*********************
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
Examples:

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
*********************/

public class Solution {
	public int[] search(int[][] matrix, int target) {
		// Algorithms: Binary Seach
		// Data Structure: transform 2D matrix to 1D array;
		int[] result = new int[2];
		if (matrix == null || matrix.legnth == 0) {

		}
		int row = matrix.length;
		int col = matrix[0].length;
		
		index = row * col - 1;


	}
}