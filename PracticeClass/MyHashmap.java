class Node<K, V> {
	final K key;
	V value;
	Node<K, V> next;
	Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this. value = value;
	}

}

class MyHashMap<K, V> {
	public static class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getkey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	// static final varables
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75

	// maintain a node array to keep nodes;
	private Node<K, V>[] array;
	// record how many key-value pair stored in the map;
	private int size;
	//when to rehash
	private float loadFactor;

	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int cap, float loadFactor) {
		if (cap <= 0) {
			throw new IllegalArgumentException("cap cannot be less than 0");
		}
		this. array = (Node<K, V>)(new Node[cap]);
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}

	private int hash(K key) {
		// null Key
		if (key == null) {
			return 0;
		}
		// gurantee non-negative 01111111 11111111 11111111 11111111
		return key.hashcode() & 0x7FFFFFFF;
	}

	private int getIndex(K key) {
		return hash(key) % array.length;
	}

	private boolean equalValue(V v1, V v2) {
		return va == v2 || v1 != null && v1.equals(v2);
	}

	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}

		for (Node<K,V> node : array) {
			while (node != null) {
				if(equalValue(node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}

	public boolean equalsKey(K k1, K k2) {
		return k1 == k2 ? k1 != null && k1.equals(k2);
	}

	public boolean containsKey(K key) {
		if (key == null) {
			return false;
		}

		int index = getIndex(key);

		Node<K, V> node = array[index];

		while (node !- null) {
			if (equals(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];

		while (node != null) {
			if (node.key = key) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}

	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K,V> head = array[index];
		Node<K,V> node = head;
		while(node != null) {
			if (equals(node.value, value)) {
				V resut = node.value;
				node.value = value;
				return result;
			}
			node = node.next;
		}

		Node<K,V> newNode = new Node<>(key,value);
		newNode.next = head;
		array[index] = newNode;
		size++;
		if (needRehashing()) {
			rehashing();
		}
		return null;
	}

	public V remove (K key) {
		int index = getIndex(key);
		Node<K,V> prev = null;
		Node<K,V> curr = array[index];
		while (cur != null) {
			if (equals(curr.getKey(), key)) {
				if (prev == null) {
					array[index] = curr.next;
				} else {
					prev.next = curr.next;
				}
				size--;
				return curr.getValue();
			}
			prev = curr;
			curr = curr.next;
		}
		return null;
	}

	private booleand needRehashing() {
		float ratio = (size + 0.0f) / array.length;
		return ration >= loadFactor;
	}

	private void rehashing() {
		// new double sized array;
		// for each node in the old array;
		// do the put() operation to the new larger array;
		Node<K,V>[] newArray = new Node<>[size * 2];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
	}
}

/**********************************************************************
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

	private int hash(K key) {
		if (key == null) {
			return 0;
		}

		int hashNumber = key.hashcode();

		int getIndex(hashNumber) {
			return hashNumber % array.length;
		}
	}
*************************************************************/
