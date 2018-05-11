/*******************************************************
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
public class ListNode {
	int val;
	ListNode next;
	TreeNode(int val) {
		this.val = val;
		next = null;
	}
}
******************************************************/

public class Practice{
	// Delete in Binary Search Tree
	public TreeNode deleteInBst(TreeNode root, int target) {
		if (root == null) {
			return root;
		}

		if (root.val > target) {
			root.left = deleteInBst(root.left, target);
			return root;
		} else if (root.val < target) {
			root.right = deleteInBst(root.right, target);
			return root;
		} else {
			// root.val == target
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// root.left != null && root.right != null
			// find out the largest node in right subtree.
			TreeNode smallest = findSmallest(root.right);
			smallest.left = root.left;
			smallest.right = root.right;
			return smallest;
		}
	}

	// find the smallest node in the right subtree
	private TreeNode findSmallest(TreeNode node) {
		// Prev is node's parent node;
		TreeNode prev = node;
		node = node.left;

		while (!node.left == null) {
			prev = node;
			node = node.left;
		}
		// prev.left.right = prev.right;
		prev.left = prev.left.right;
	}

}
