public class Solution {
	public String[] topKFrequent(String[] combo, int k) {
		if (combo == null) {
			return new String[0];
		}
		
		Map<String, Integer> map = getWords(combo);
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if (e1.getValue().equals(e2.getValue())) {
					return 0;
				}
				return e1.getValue() < e2.getValue() ? -1 : 1;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxHeap.size() < k) {
				maxHeap.offer(entry);
			} else if (entry.getValue() > maxHeap.peek().getValue()) {
				maxHeap.poll();
				maxHeap.offer(entry);
			}
		}
		String[] result = new String[maxHeap.size()];
				
		for (int i = maxHeap.size() - 1; i >= 0; i++) {
			result[i] = maxHeap.poll();
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