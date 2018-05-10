KCloestInSortedArray.java
/***************************************************************
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T. 
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
***************************************************************/

public class Solution {
  	public int[] kClosest(int[] array, int target, int k) {
    	// Write your solution here
  	}

	private int largestSmaller(int[] array, int left, int right) {
  		int mid = left + (right - left) / 2;

  		while (left < right - 1) {
  			if (array[mid] == target) {
  				return mid;
  			}
  			else if (array[mid] < target) {
  				left = mid;
  			}
  			else {
  				right = mid;
  			}
  		}
  		if (array[right] >= target && array[left] <= target) {
  			return right;
  		}

	}

}
