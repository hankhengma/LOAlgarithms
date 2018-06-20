/********************************
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.value = value;
	}
}
********************************/
// Time: O(logn)
// Space: O(logn)
public class PrintBinaryTree {

	public void print(TreeNode root) {
		if (root == null) {
			return;
		}

		Deque<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);// pollLast();

		while (!queue.isEmpty()) {
			// 因为要分层打印 所以首先找到每层的断点：当前层的queue为空；
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollLast();
				if (node.left != null) {
					queue.offerFirst(node.left);
				}
				if (node.right != null) {
					queue.offerFirst(node.right);
				}

				System.out.print(node.value + " ");
			}
			System.out.println();
		}
	}
}


// step 1: expend a node;
// step 2: generate its neighbor nodes;
// step 3: terminate: queue is empty;
// step 4: data structure: FIFO queue; 