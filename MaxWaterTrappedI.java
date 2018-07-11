public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int result = 0;
        int lMax = array[left];
        int rMax = array[right];
        while (left < right) {
            // who smaller who moves;
            lMax = Math.max(lMax, array[left]);
            rMax = Math.max(rMax, array[right]);
            if (lMax < rMax) {
                result += lMax - array[left];
            } else {
                result += rMax - array[right];
            }
        }
        /*****************************************************
        for (int i = 0; i < array.length; i++) {
            int leftI = i - 1;
            int rightI = i + 1;
            int leftMax = 0;
            int rightMax = 0;
            while (leftI >= 0) {
                leftMax = Math.max(leftMax, array[leftI--]);
            }

            while (rightI < array.length) {
                rightMax = Math.max(rightMax, array[rightI++]);
            }
            int top = Math.min(leftMax, rightMax);
            result += top - array[i] < 0 ? 0 : top - array[i];
        } // time: On^2;
        ********************************************************/
        return result; // time : On
	} 
}





/***********************************


A 5      3      2      1     4      6
R 0      2      3      4     1      0
  (5, 6) (5, 6) (5, 6) (5,6) (5, 6) (5,6)
we need to find out the leftBound, rightBound and the topBound;
for each element's capability holding water:
	the leftBound and rightBound should be the index;
	the topBound should be the min(leftMax, rightMax) -- left/rightMax means the highest element of current ele's left/right part;

	leftMax;
	rightMax;
	top

	top = min(leftMax, rightMax);
	result = top - array[i];
	sum all the results up.