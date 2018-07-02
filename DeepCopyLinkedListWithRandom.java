class RandomListNode {
	public int value;
	public RandomListNode next;
	public RandomListNode random;
	public RandomListNode(int value) {
		this.value = value;
	}
}



public class DeepCopyLinkedListWithRandom {
	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> dic = new HashMap<>();
		RandomListNode newhead = new RandomListNode(head.value);
		dic.put(head, newHead);
		RandomListNode curr = newHead;

		while (head != null) {
			if (head.next != null) {
				if (!dic.containsKey(head.next)) {
					dic.put(head.next, new RandomListNode(head.next.value));
				}
				curr.next = dic.get(head.next);
			}
			if (head.random != null) {
				if (!dic.containsKey(head.random)) {
					dic.put(head.random, new RandomListNode(head.random.value));
				}
				curr.random = dic.get(head.random);
			}

			head = head.next;
			curr = curr.next;
		}
		return newHead;
	}
}