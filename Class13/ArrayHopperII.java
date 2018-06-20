public class Solution {
  public int minJump(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 1) {
		return 0;
	}
		
	int[] minSteps = new int[array.length];
	minSteps[array.length - 1] = 0;
		
	for (int i = array.length - 2; i >= 0; i--) {
		if (i + array[i] >= array.length - 1) {
			minSteps[i] = 1;
		} else {
			int curMin = Integer.MAX_VALUE;
			minSteps[i] = -1;
			for (int j = array[i]; j >= 1; j--) {
				if (minSteps[i + j] == -1) {
					continue;
				} else {
					if (curMin > minSteps[i + j]) {
						curMin = minSteps[i + j];
					}
				}
				minSteps[i] = curMin + 1;
				}
			}
		}
		return minSteps[0];
  	}
}
