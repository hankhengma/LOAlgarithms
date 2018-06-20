public class MaximumPathSumOfBinaryTreeI {
	public int maxSum(TreeNode root) {
		int[] max = new int[]{0};
		sumHelper(root, max);
		return max[0];
	}

	private int sumHelper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		int leftSum = sumHelper(root.left, max);
		int rightSum = sumHelper(root.right, max);

		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], leftSum + rightSum + root.value);
			return max[0] + root.value;
		}
		return left == null ? rightSum + root.value : leftSum + root.value;
	}
}
