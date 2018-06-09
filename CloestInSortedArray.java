public class Solution {
  public int closest(int[] array, int target) {
    // Write your solution here
    if (array.length == 0 || array == null) {
    	return -1;
    }
    int arrayLength = array.length;
    int left = 0;
    int right = arrayLenght - 1;

    while (left < right - 1) {
    	int mid = left + (right - left) / 2;
      
      if (array[mid] == target) {
      	return mid;
      }
      else if(array[mid] > target) {
      	right = mid;
      }
      else {
      	left = mid;
      }
    }
    return Math.abs(target - array[left]) <= Math.abs(array[right] - target) ? left : right;
  }
}

// Algorithm: binary search;
// Time: OlogN;
// use binary search to try to find target;
// if the target exists then return the index;
// if doesn't findout then use binary search to find out the closest two elements
// then compare the diffs between left ele and target and right ele with target.