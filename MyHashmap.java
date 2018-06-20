class Node<K, V> {
	final K key;
	V value;
	Node<K, V> next;
	Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {}

	public V getValue() {}

	public void setValue(V value) {}

}

class MyHashMap {
	private int SIZE;
	private int CAPACITY = 16;
	private float LOAD_FACTOR = 0.75f;
	private Node<String, Integer>[] array;
	public MyHashMap() {
		array = new Node<String, Integer>[CAPACITY];
		SIZE = 0;
	}

	public MyHashMap(int capacity) {
		array = new Node<String, Integer>[capacity];
		CAPACITY = capacity;
		size = 0;
	}

	public MyHashMap(int capacity, float loadFactor) {
		array = new Node<String, Integer>[capacity];
		size = 0;
		LOAD_FACTOR = loadFactor;
		CAPACITY = capacity;
	}

	public Integer put(String key, Integer value) {
		// get hashcode
		int hashCode = 0;
		if (key != null) {
			hashCode = hash(key);
		}
		// get index
		int index = hashCode % CAPACITY;

		// iterate the singlely linkedlist
		Node<String, Integer> node = array[index];
		Integer result = null;
		// update
		while (node != null) {
			if (keyEquals(key, node.getkey())) {
				Integer result = node.getValue();
				node.setValue(value);
				return result;
			}
			node = node.next;
		}

		Node<String, Integer> newNode = new Node<String, Integer>(key, value);
		newNode.next = array[index];
		array[index] = newNode;
		size++;
		//rehash
		if (needsRehash) {
			rehash();
		}
		return null;
	}

	public Integer get(String key) {
		int hashCode = 0;
		if (key != null) {
			hashCode = hash(key);
		}

		// find index of the node array
		int index = hashCode % CAPACITY;
		Node<String, Integer> node = array[index];
		while (node != null) {
			if (keyEqual(key, node.getKey())) {
				return node.getValue();
			}
			node = node.next;
		}
		return null;
	}

	public Integer remove(String key) {
		// count hashNode
		int hashCode = 0;
		if (key != null) {
			hashCode = hash(key);
		}
		// find index
		int index = hashCode % CAPACITY;

		Node<String, Integer> node = array[index];
		//find the node in the linkedlist
		if(array[index]==null){
			return null;
		}

		if (node != null && keyEquals(key, node.getKey())) {
			size--;
			Integer result = array[index].getValue();
			array[index] = array[index].next;
			return result;
		} 
		Node<String, Integer> prev = array[index];
		while (node != null) {
			// if (keyEqual(node.getKey(), key)) {
			// 	prev.next = node.next;
			// 	size--;
			// 	return node.getValue();
			// }
			// node = node.next;
			// prev = prev.next;
			
		}
		return null;
	}
}