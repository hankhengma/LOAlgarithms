/************************
public class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}
**************************/

public class MiddleNodeOfLinkedList {
	
	// use fast and slow pointers to find out the middle node.
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode fast = head, slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}