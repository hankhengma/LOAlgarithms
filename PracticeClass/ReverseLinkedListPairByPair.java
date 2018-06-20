public class ReverseLinkedListPairByPair {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next = null) {
			return head;
		}

		ListNode next = head.next;
		ListNode newHead = reverse(head.next.next);
		next.next = head;
		head.next = newHead;
		return next;
	}
}