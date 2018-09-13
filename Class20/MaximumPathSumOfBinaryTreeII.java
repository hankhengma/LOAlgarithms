/********************************
Given a binary tree in which each node contains an integer number. 
Find the maximum possible sum from any node to any node 
(the start node and the end node can be the same). 
********************************/
public class MaximumPathSumOfBinaryTreeII {
	public static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public int maxPath(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		maxPathHelper(root, max);
		return max[0];
	}

	private int maxPathHelper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		int left = maxPathHelper(root.left, max);
		int right = maxPathHelper(root.right, max);

		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;

		max[0] = Math.max(max[0], root.key + left + right);
		return root.key + Math.max(left, right);
	}
}