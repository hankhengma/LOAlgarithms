/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    ListNode cur = dummy;
    
    while (one != null && two != null) {
    	if (one.value < two.value) {
      	cur.next = one;
        one = one.next;
      } else {
      	cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    if (one != null) {
    	cur.next = one;
      one = one.next;
    }
    if (two != null) {
    	cur.next = two;
      two = two.next;
    }
    return dummy.next;
  }
}
