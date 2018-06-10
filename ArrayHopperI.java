public class ArrayHopperI {
	public boolean canJump(int[] array) {
		if (array.length <= 1) {
			return true;
		}

		boolean[] canJump = new boolean[array.length];
		
		// canJump[i] -- can jump to the end from ith ele;
		// base case: canJump[]
		canJump[array.length - 1] = true;
		for(int i = array.length - 2; i >= 0; i--) {
			if (array[i] + i >= array.length - 1) {
				canJump[i] = true;
			} else {
				// if ith cannot jump to the end;
				// check within the maximum jump steps from ith;
				// whethere there is a j can jump to the end;
				for (int j = array[i]; j > i; j--) {
					if(canJump[i + j]) {
						canJump[i] = true;
						break;
					}
				}
			}
		}
		return canJump[0];
	}	
}