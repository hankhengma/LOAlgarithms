ReverseLinkedList.java

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 **/

public class ReverseLinkedList {
	// Iterative method
	public ListNode reverse(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	// Recursion Method
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null)	{
			return head;
		}

		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
}

