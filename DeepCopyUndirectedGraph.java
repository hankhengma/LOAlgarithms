class GraphNode {
	public int key;
	public List<GraphNode> neighbors;
	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}

}

public class DeepCopyUndirectedGraph {
	public List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) {
			return graph;
		}

		List<GraphNode> result = new ArrayList<>();
		Map<GraphNode, GraphNode> lookup = new HashMap();
		
	}

	private GraphNode copy(GraphNode node, Map<GraphNode, GraphNode> lookup) {
		if (node == null)
	}
}
