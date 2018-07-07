public class LowestCommonAncestorInBST {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		// Assumption: a < b
		if (root == null || root == a || root == b) {
			return root;
		}

		if (root.key < a.key) {
			return lowestCommonAncestor(root.right, a, b);
		} else if (root.key > b.key) {
			return lowestCommonAncestor(root.left, a, b);
		} else {
			return root;
		}
		
	}
}