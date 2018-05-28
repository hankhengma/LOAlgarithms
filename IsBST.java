public class Solution {
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if (root == null) {
    	return true;
    }
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    
    return isBST(root, min, max);
  }
  
  private boolean isBST(TreeNode root, int min, int max) {
  	if (root == null) {
    	return true;
    }
    if (root.key <= min || root.key >= max) {
    	return false;
    }
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
}
