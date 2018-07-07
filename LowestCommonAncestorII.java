/******************************
the tree with parent node;
******************************/


public class LowestCommonAncestorII {
	static class TreeNodeP {
		int key;
		TreeNodeP left;
		TreeNodeP right;
		TreeNodeP parent;
		TreeNodeP(int key, TreeNodeP parent) {
			this.key = key;
			this.parent = parent;
		}
	}

	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		if (one == null || two == null) {
			return null;
		}

		int heightOne = getHeight(one);
		int heightTwo = getHeight(two);
		int diff = Math.abs(heightOne - heightTwo);

		if (heightOne < heightTwo) {
			return traceUp(one, two, diff);
		} else {
			return traceUp(two, one, diff);
		}
	}

	private TreeNodeP traceUp(TreeNodeP upper, TreeNodeP lower, int diff) {
		while (diff > 0) {
			--diff;
			lower = lower.parent;
		}
		while (lower != upper) {
			lower = lower.parent;
			upper = upper.parent;
		}
		return lower;
	}

	private int getHeight(TreeNodeP node) {
		int height = 0;
		while (node != null) {
			node = node.parent;
			++height;
		}
		return height;
	}
}