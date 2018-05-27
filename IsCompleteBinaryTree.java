public class Solution {
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean noChild = false;

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			if (cur.left == null) {
				noChild = true;
			} else if (noChild) {
				return false;
			} else {
				queue.offer(root.left);
			}

			if (cur.right == null) {
				noChild = true;
			} else if (noChild) {
				return false;
			} else {
				queue.offer(root.right);
			}
		}
		return true;
	}
}