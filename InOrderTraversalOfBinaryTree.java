// public class TreeNode {
// 	public int key;
// 	public TreeNode left;
// 	public TreeNode right;
// 	public TreeNode(int key) {
// 		this.key = key;
// 	}

// }

/******************题目要求不可以用recursion*************
public class Solution {
	public List<Integer> inOrder(TreeNode root) {
		if (root == null) {
			return result.add('#');
		}

		List<Integer> result = new ArrayList<>();
		TreeNode left = inOrder(root.left);
		result = result.add(left.key);
		result = result.add(root.key);
		TreeNode right = inOrder(root.right);
		result.add(right.key);
		return result;
	}
}
*****************************************************/