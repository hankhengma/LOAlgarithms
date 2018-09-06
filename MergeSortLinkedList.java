public class MergeSortLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next) {
			return head;
		}

		ListNode mid = findMid(head);
		ListNode rightHead = mid.next;
		mid.next = null;

		ListNode left = mergeSort(head);
		ListNode right = mergeSort(rightHead);
		return merge(left, right);
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 != null) {
			cur.next = head1;
			head1 = head1.next;
		}

		if (head2 != null) {
			cur.next = head;
			head2 = head2.next;
		}

		return dummy.next;
	}
}

// 2 - null