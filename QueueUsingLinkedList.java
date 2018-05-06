
public class ListNode {
	int key;
	ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}


// Implement a Queue with Linked List;
// fields: head; tail; 
// functions: enqueue() -- offer; dequeue() -- poll; peek();
public class Queue {
	private ListNode head;
	private ListNode tail;
	public queue() {
		head = tail = null;
	}

	// Insert to the tail of the queue
	public boolean offer(Integer value) {
		ListNode<Integer> node = new ListNode<>(value);
		if (head == null) {
			head = node;
			tail = head;
		}
		else {
			tail.next = node;
			tail = tail.next;
		}
		return true;
	}

	// return the head of the queue and remove it from the queue
	public Integer poll() {
		if(head == null) {
			return null;
		}

		ListNode<Integer> node = new ListNode<>();
		node = head;
		head = head.next;
		// check if the queue is empty after head move to the next;
		// if empty head = tail = null;
		if (head == null) {
			tail = null;
		}
		node.next = null;
		return node.value;
	}

	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}

}