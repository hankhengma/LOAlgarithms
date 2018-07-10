public class KthClosestPointTo000 {
	public List<Integer> kthClosest(int[] x, int[] y, int[] z, int k) {
		Set<List<Integer>> visited = new LinkedList<>();
		PriorityQueue<List<Integer>> min = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				long dis1 = getDistance(o1, x, y, z);
				long dis2 = getDistance(o2, x, y, z);
				if (dis1 == dis2) {
					return 0;
				}
				return dis1 < dis2 ? -1 : 1;
			}
		});
		List<Integer> cur = Arrays.asList(0,0,0);
		visited.add(cur);
		min.offer(cur);

		while (k > 1) {
			cur = min.poll();
			List<Integer> tmp = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if (tmp.get(0) < x.length && visited.add(tmp)) {
				min.offer(tmp);
			}
			tmp = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if (tmp.get(1) < y.length && visited.add(tmp)) {
				min.offer(tmp);
			}
			tmp = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if (tmp.get(2) < z.length && visited.add(tmp)) {
				min.offer(tmp);
			}
			
			cur.set(0, x[min.peek().get(0)]);
			cur.set(1, y[min.peek().get(1)]);
			cur.set(2, z[min.peek().get(2)]);
			return cur;
		}
	}

	private long getDistance(List<Integer> o1, int[] x, int[] y, int[] z) {
		long dis = 0;
		dis += x[o1.get(0)] + x[o1.get(0)];
		dis += x[o1.get(1)] + x[o1.get(1)];
		dis += x[o1.get(2)] + x[o1.get(2)];
		return dis;
	}
}

