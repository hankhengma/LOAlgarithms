public class KthSmallestWithOnly357AsFactors {
	public long kth(int k) {
		PriorityQueue<Integer> min = new PriorityQueue<>(k, new Comparator<>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				if (n1 == n2) {
					return 0;
				}
				return n1 < n2 ? -1 : 1;
			}
		});
		Set<Integer> visited = new HashSet<>();
		min.offer(3*5*7L);
		visited.add(3*5*7L);

		while (k > 1) {
			long cur = min.poll();
			if (visited.add(3 * cur)) {
				min.offer(3 * cur);
			}
			if (visited.add(5 * cur)) {
				min.offer(5 * cur);
			}
			if (visited.add(7 * cur)) {
				min.offer(7 * cur);
			}
			k--;
		}
		return min.peek();
	}
}
