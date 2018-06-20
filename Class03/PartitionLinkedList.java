/****************************
Description
Given a linked list and a target value T, 
partition it such that all nodes 
less than T are listed 
before the nodes larger than or equal to target value T. 
The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

***************************/

// 解题思路：两个dummy nodes分别存比target大和比target小的数 
class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class Solution {
	public ListNode partition(ListNode head, int target) {
		// todo
		ListNode larger = new ListNode();
		ListNode smaller = new ListNode();
		// 我们需要存两个cur nodes; 
		ListNode curLarger = larger;
		ListNode curSmaller = smaller;

		while (cur != null) {
			if (target =< cur.value) {
				curLarger.next = head;
				curLarger = curLarger.next;
			} else {
				curSmaller.next = head;
				curSmaller = curSmaller.next;
			}
			cur = cur.next;
		}

		// combine to linked list
		curSmaller.next = larger.next;
		curLarger.next = null;
		return smaller.next;
	}
}
