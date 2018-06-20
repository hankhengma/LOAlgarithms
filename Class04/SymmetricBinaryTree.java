/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here
    if (root == null) {
    	return true;
    }
    
    return isSymmetric(root.left, root.right);
  }
  
  private boolean isSymmetric(TreeNode left, TreeNode right) {
  	if (left == null && right == null) {
    	return true;
    } else if (left == null || right == null) {
    	return false;
    } else if (left.key != right.key) {
    	return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }
}
