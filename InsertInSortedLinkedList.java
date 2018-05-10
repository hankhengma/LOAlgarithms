public class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}	
}


public class InsertInSortedLinkedList {
	
	public ListNode insert(ListNode head, int target) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode new = new ListNode(target);

		while (head != null) {
			if (head.value == target) {
				head.next = new;
			}
			else if (head.value < target) {
				dummy.next = new;
				new.next = head;
			}
			else {
				head.next = new;
			}
			head = head.next;
		}
		return dummy.next;
	}
}
