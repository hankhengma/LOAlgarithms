/******************
find the LCA of k nodes in binary tree
******************/
public class LowestCommonAncestorIV {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	// iteration
	// find the LCA of two nodes first
	// use the result to find the LCA with the rest nodes one by one
	public TreeNode lca(TreeNode root, List<TreeNode> nodes) {
		if (root == null || nodes == null || nodes.size() == 0) {
			return null;
		}
		// initialization;
		TreeNode[] result = new TreeNode[]{null};
        TreeNode[] nodeArray = new TreeNode[nodes.size()];
        int index = 0;
        for (TreeNode node : nodes) {
            nodeArray[index++] = node;
        }
        result[0] = findLca(root,nodeArray[0], nodeArray[1],result);

        for (int i = 2; i < nodes.size(); i++) {
            result[0] = findLca(root,nodeArray[i],result[0],result);
        }
        return result[0];
	}

	// K way together
	public TreeNode findLcaI(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		if (root == null || set.contains(root)) {
			return root;
		}

		TreeNode left = findLcaI(root.left, nodes);
		TreeNode right = findLcaI(root.right, nodes);

		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	private TreeNode findLca(TreeNode root, TreeNode n1, TreeNode n2, TreeNode[] result) {
		if (root == null || root == n1 || root == n2) {
			return root;
		}

		TreeNode left = findLca(root.left, n1, n2, result);
		TreeNode right = findLca(root.right, n1, n2, result);

		if (left != null && right != null) {
			result[0] = root;
		} else {
			result[0] = left == null ? right : left;
		}
		return result[0];
	}
}