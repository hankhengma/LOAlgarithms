
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
		}
		else if(tail == null) {
			tail = node;
		}

		tail.next = node;
		tail = node;
		return true;
	}

	// return the head of the queue and remove it from the queue
	public Integer poll() {
		if(head == null && head == tail) {
			return null;
		}

		ListNode<Integer> node = new ListNode<>();
		node = head;
		head = head.next;
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