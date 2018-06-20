// time: 
// space: 
public class Solution {
	public boolean isBipartite(List<GraphNode> graph) {
		HashMap<GraphNode, Character> visited = new HashMap<>();

		for (GraphNode node : graph) {
			if (!isBipartite(node, visited)) {
				return false;
			}
		}
		return true;
	}

	private boolean isBipartite(GraphNode node, HashMap<GraphNode, Character> visited) {
		if (visited.containsKey(node)) {
			return true;
		}

		Queue<GraphNode> queue = new Queue<>();
		queue.offer(node);
		visited.put(node, 'r');

		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neighborGroup = curGroup == 'r' ? 'b' : 'r';

			for (GraphNode neighbor : cur.neighbors) {
				if (!visited.containsKey(neighbor)) {
					queue.offer(neighbor);
					visited.put(neighbor, neighborGroup);
				} else if (visited.get(neighbor) != neighborGroup) {
					return false;
				}
			}
		}
		return true;
	}
}