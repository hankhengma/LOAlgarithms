public class LCAKNodesInKnaryTree {
	static class TreeNode {
		int key;
		List<TreeNode> children;
		TreeNode(int key) {
			this.key = key;
			this.children = new ArrayList<>();
		}
	}

	public TreeNode lca(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		if (root == null || set.contains(root)) {
			return root;
		}

		int counter = 0;
		TreeNode node = null;
		for (TreeNode child : root.children) {
			TreeNode temp = lca(child, nodes);
			if (temp != null) {
				++counter;
				if (counter > 1) {
					return root;
				}
			}
		}
		return node;
	}
}