public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here
    if (array.length == 0 || array == null) {
    	return -1;
    }
    
    int left = 0;
    int right = array.length - 1;
    /*****************************************
    while (left < right - 1) {
    	int mid = left + (right - left) / 2;
      
      if (array[mid] == target) {
      	return mid;
      }
      else if (array[mid] < target) {
      	left = mid;
      }
      else if (array[mid] > target) {
      	right = mid;
      }
    }
    if (array[left] == target) {
      return left;
    }
    if (array[right] == target) {
      return right;
    }
    *****************************************/
    // array[mid]已经被比较过了 如果不是的话 可以看前一位/下一位 所以是mid+1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
    	if (array[mid] == target) {
      	return mid;
      }
      else if (array[mid] > target) {
      	right = mid - 1;
      }
      else {
      	left = mid + 1;
      }
    } 
    return -1;
  }
}
