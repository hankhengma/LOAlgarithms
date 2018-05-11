
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class PostOrderTraverseBinaryTree {
	public List<Integer> postOrder(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode pre = null;
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if (prev == null || cur == prev.left || cur == prev.right) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					result.add(stack.pollFirst().value);
				}
			} else if (prev == cur.left) {
				// left subtree has been traversed
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					result.add(stack.pollFirst().value);
				}
			} else if (prev == cur.right) {
				result.add(stack.pollFirst().value);
			}
			prev = cur;
		}
		return result;
	}
}