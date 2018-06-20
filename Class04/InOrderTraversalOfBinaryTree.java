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

public class Solution {
	public List<Integer> inOrder(TreeNode root) {
		if (root == null) {
			return root;
		}

		List<Integer> result = new ArrayList<>();
		// use a buffer to store the "root" node
		// the left side of the root node is the left child tree
		// the right side idea is same as the left side.
		Deque<TreeNode> buffer = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !buffer.isEmpty()) {
			// store the root node;
			// find the root.left and insert it into the buffer;
			// the left node is always inserted at the front of the buffer;
			if (cur != null) {
				buffer.addFirst(cur);
				cur = cur.left;
			}
			// if the left side has been finished;
			// print out the first element in the buffer;
			// the last element is the root node;
			else {
				// buffer.pollLast(); -- as the most left node was stored at the most front
				cur = buffer.pollFirst();
				result.add(cur.key);
				cur = cur.right;
			}
		}
		return result;
	}
}