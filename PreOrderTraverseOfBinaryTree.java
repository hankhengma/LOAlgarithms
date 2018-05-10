/*********************************
public class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
**********************************/

public class Solution {
	public List<Integer> preOrder(TreeNode root) {
		if (root == null) {
			return root;
		}
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);

		while (!stack.isEmpty()) {
			result.add(stack.pollFirst());

			if (root.right != null) {
				stack.offerFirst(root.right);
			}
			else if (root.left != null) {
				stack.offerFist(root.left);
				root = root.left;
			}
		}
		return result;
	}
}