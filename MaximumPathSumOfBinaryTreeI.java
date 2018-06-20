public class MaximumPathSumOfBinaryTreeI {
	public int maxSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
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
			return Math.max(leftSum, rightSum) + root.value;
		}
		return left == null ? rightSum + root.value : leftSum + root.value;
	}
}
