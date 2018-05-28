public class Solution {
	public String[] topKFrequent(String[] combo, int k) {
		if (combo == null) {
			return new String[0];
		}
		String[] result = new String[k];
		Map<String, Integer> map = getWords(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if (e1.getValue().equals(e2.getValue())) {
					return 0;
				}
				return e1.getValue() < e2.getValue() ? -1 : 1;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}

		for (int i = minHeap.size() - 1; i >= 0; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}

	private Map<String, Integer> getWords(String[] combo) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		for (String str : combo) {
			Integer frequency = frequencyMap.get(str);
			if (frequency == null) {
				frequencyMap.put(str, 1);
			} else {
				frequencyMap.put(str, frequency + 1);
			}
		}
		return frequencyMap;
	}
}