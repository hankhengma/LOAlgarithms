public class LowestCommonAncester {
	public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || root == a || root == b) {
			return root;
		}

		TreeNode left = lca(root.left, a, b);
		TreeNode right = lca(root.right, a, b);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right : left;
	}
}