public class Solution {
  public int closest(int[] array, int target) {
    // Write your solution here
    if (array.length == 0 || array == null) {
    	return -1;
    }
    
    int left = 0, right = array.length - 1;
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
    
    if((array[right] - target) < (target - array[left])) {
    	return right;
    }
    else {
    	return left;
    }
  }
}

// 1,3,3,4 t =2;
// if target exists then return the index of target;
// if target doesn't exist then find then nearest 2 elements in the array.