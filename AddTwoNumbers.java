public class AddTwoNumbers {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode add(ListNode head1, ListNode head2) {
		// assum head1 and head2 are not null

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummy;
		ListNode temp;
		int carry = 0;
		int sum = 0;

		while (head1 != null || head2 != null) {
			sum = carry + (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0);
			if (sum >= 10) {
				carry = 1;
			}
			sum = sum % 10;
			temp = new ListNode(sum);
			cur.next = temp;
			cur = cur.next;
			
			if (head1 != null) {
				head1 = head1.next;
			}
			if (head2 != null) {
				head2 = head2.next;
			}
		}

		if (carry == 1) {
			cur.next = new ListNode(carry);
		}


		return dummy.next;
	}
}
/***************************888
     c1
2 -> 4 -> 3 == 342
5 -> 6 -> 4 == 465
     c2
============

         c
dummy -> 7 -> 0 -> 7+carry
			  carry = 1

int carry
if sum > 9 -- carry = 1
	else carry = 0

    h1
9 9 9
9 9 
    h2 
8 9 0 1 
    1
