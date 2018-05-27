/****************
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
***************/

public class Solution {
	public ListNode reorder(ListNode head) {
		// 3 step:
		// 1. split the linked list into two.
		// 2. reverse the right part
		// 3. merge the two lists.
		ListNode mid = findMiddle(head);
		ListNode left = head;
		ListNode right = mid.next;
		mid.next = null;

		reverse(right);

		merge(left,right);
	}

	private ListNode findMiddle(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode node) {
		/*******Iterative***************
		ListNode prev = null;

		while (node != null) {
			ListNode next = node.next;

			node.next = prev;
			prev.next = node;
			node = next;
		}
		return node;
		**************************/

		if (node == null || node.next == null) {
			return node;
		}

		ListNode newHead = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummy;

		while (one != null && two != null) {
			cur.next = one;
			// one.next = two;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		if (one != null) {
			cur.next = one;
			one = one.next;
		} else {
			cur.next = two;
			two = two.next;
		}
		return dummy.next;
	}
}