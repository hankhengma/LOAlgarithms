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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    
    if (root == null) {
    	return result;
    }
    getRange(root, min, max, result);
    return result;
  }
  
  private void getRange(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
    	return;
    }
    
  	if (root.key > min) {
    	getRange(root.left, min, max, result);
    }
    if (root.key >= min && root.key <= max) {
    	result.add(root.key);
    }
    if (root.key < max) {
    	getRange(root.right, min, max, result);
    }
     
  }
}
