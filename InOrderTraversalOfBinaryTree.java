// public class TreeNode {
// 	public int key;
// 	public TreeNode left;
// 	public TreeNode right;
// 	public TreeNode(int key) {
// 		this.key = key;
// 	}

// }


public class Solution {
	public List<Integer> inOrder(TreeNode root) {
		if (root == null) {
			return result.add('#');
		}

		List<Integer> result = new ArrayList<>();
		TreeNode left = inOrder(root.left);
		result = result.add(left);
		result = result.add(root);
		TreeNode right = inOrder(root.right);
		result.add(right);
		return result;
	}
}
