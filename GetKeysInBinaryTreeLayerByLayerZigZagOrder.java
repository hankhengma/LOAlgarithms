public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
	public List<Integer> zigZag(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offer(root);
		int curLevel = 0;

		while (!deque.isEmpty()) {
			TreeNode curNode;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				if (curLevel % 2 != 0) {
					curNode = deque.pollLast();
					result.add(curNode.key);
					if (curNode.left != null) {
						deque.offerFirst(curNode.left);
					}
					if (curNode.right != null) {
						deque.offerFirst(curNode.right);
					}
				} else {
					curNode = deque.pollFirst();
					result.add(curNode.key);
					if (curNode.right != null) {
						deque.offerLast(curNode.right);
					}
					if (curNode.left != null) {
						deque.offerLast(curNode.left);
					}
				}
			}
			curlevel++;
		}
		return result;
	}
}