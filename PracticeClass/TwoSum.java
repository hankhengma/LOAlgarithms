public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int sum = 0;
		int[] result = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			sum = nums[i];
			for (int j = 1; j < nums.length; j++) {
				sum += nums[j];
				if (sum == target) {
					result = {i,j};
					return result;
				}
			}
		}
	}

	public int[] twoSum(int[] nums, int target) {
		int sum = 0;
		int slow = 0;
		int fast = nums.length - 1;

		while (slow < fast - 1) {
			sum = nums[slow] + nums[fast];
			if (sum == target) {
				result[0] = slow;
				result[1] = fast;
				return result;
			} else if (sum < target) {
				slow++;
			} else {
				fast--;
			}
		}
		return null;
	}
}
