public class IsCousinsInBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean isCousine(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || root == a || root == b) {
			return false;
		}

		if ()
		
	}

	private int getLevel(TreeNode root, TreeNode a, TreeNode b, int level) {
		// base case:
		if (root == null) {
			return -1;
		}
		if (root == a || root == b) {
			return level;
		}
		// using 3 step:
		// step 1;
		int left = getLevel(root.left, a, b, level + 1);
		int right = level(root.right, a, b, level + 1);
		// step 2
		// step 3
		return left > right : left : right;
	}
}


		1
	  /   \
	2 		3
   / \     / \	
  4   5   6   7

  1,5,7