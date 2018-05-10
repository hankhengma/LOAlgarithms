/*******************************
public TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}
}
*****************************/
public class DeleteInBST {
	public TreeNode deleteInBST(TreeNode root, int target) {
		if (root == null) {
			return root;
		}

		// find the target first
		if (root.value > target) {
			root.left = deleteInBST(root.left, target);
			return root;
		}
		else if (root.value < target) {
			root.right = deleteInBST(root.right, target);
			return root;
		}

		// root.value == target
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}

		// root.left != null && root.right != null
		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		} else {
			// find the smallest node in the right child subtree and delete it.
			TreeNode smallest = deleteSmallest(root.right);
			smallest.left = root.left;
			smallest.right = root.right;
			return smallest;
		}
	}

	private TreeNode deleteSmallest(TreeNode root) {
		TreeNode prev = root;
		root = root.left;

		while (!root.left == null) {
			prev = root;
			root = root.left;
		}
		
		prev.left = prev.right.left;
		return root;
	}
}