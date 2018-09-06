public clas LRUCache<K, V> {
	static class ListNode<K, V> {
		ListNode<K, V> prev;
		ListNode<K, V> next;
		K key;
		V value;
		ListNode<K, V>(K key, V value) {
			this.key = key;
			this.value = value;
		}

		void update(K key, V value) {
			this(key, value);
		}
	}

	private final int capacity;
	private ListNode<K, V> head;
	private ListNode<K, V> tail;
	private Map<K, V> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<K, ListNode<K,V>>();
	}

	public void set(K key, V value) {
		ListNode<K, V> node = null;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			remove(node);
		} else if (map.size() < capacity) {
			node = new ListNode<K, V>(key, value);
		} else {
			node = tail;
			remove(node);
			node = update(key, value);
		}
		append(node);
	}

	public V get(K key) {
		ListNode node = map.get(key);
		if (node == null) {
			return null;
		}
		remove(node);
		append(node);
		return node.value;
	}

	public ListNode<K, V> append(ListNode<K, V> node) {
		map.put(node.key, node.value);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		return node;
	}

	public ListNode<K, V> remove(ListNode<K, V> node) {
		map.remove(node.key);
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == head) {
			head = head.next;
		}
		if (node == tail) {
			tail = tail.prev;
		}
		node.next = node.prev = null;
		return node;
	}
}