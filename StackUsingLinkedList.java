/*********************************
 class ListNode {
	int value;
	ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}
**********************************/

// using a Linked List to implement a Stack
// field: size;
// function: boolean isEmpty(); void push(); Integer pop(); Integer top();
public class Stack {
	// Stack has no size;
	//private int size;
	private ListNode head;
	public Stack() {
		head = null;
	}

	public void push(int value) {
		ListNode<Integer> node = new ListNode<Integer>(value);
		if (head == null) {
			head = node;
		}
		node.next = head;
		//head.next = node;
		node = head;
		//size++;
	}

	public Integer pop() {
		ListNode<Integer> node = new ListNode<>();
		if (head == null) {
			return null;
		}

		node = head;
		head = head.next;
		node.next = null;
		return node.value;
	}

	public Integer top() {
		if (head == null) {
			return null;
		}

		return head.value;
	}

	// private boolean isEmpty() {
	// 	return size == 0;
	// }
}