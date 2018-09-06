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
      int[] result = new int[k]; 
      if (array == null || array.length == 0) {
        return result;
    }

    int left = largestSmallerEqual(array, 0, array.length - 1, target);;
    int right = left + 1;

    for (int i = 1; i < k; i++) {
        // condition 1: left--; why? right is out of bound or left is closer to the target than right;
        // condition 2: right++; why? the opposite to the condision 1;
        if (right > array.length - 1 || left >= 0 && target - array[left] < array[right] - target) {
          result[i] = array[left--];
      } else {
          result[i] = array[right++];
      }
  }
}

    private int largestSmallerEqual(int[] array, int left, int right, int target) {
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

          // check the right is smaller or larger than target
          // cause we need to find the largest smaller/qual than target;
    if (array[right] <= target) {
      return right;
    }

    if (array[left] <= target) {
      return left;
    }
          // cannot find anyone.
    return -1;
}

}
