/************************************
public class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}
************************************/

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		// Using fast and slow pointers. if fast.next = slow then return true. else return false;
		if (head == null || head.next == null) {
			// return head;
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			if (fast.next == slow) {
				return true;
			}
			else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return false;
	}
}