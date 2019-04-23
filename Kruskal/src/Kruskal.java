import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	static int N = 9;

	public static void main(String[] args) {

		Graph graph = new Graph(N);
		graph.addEdge(1, 2, 4);
		graph.addEdge(2, 3, 8);
		graph.addEdge(3, 4, 7);
		graph.addEdge(4, 5, 9);
		graph.addEdge(5, 6, 10);
		graph.addEdge(6, 7, 2);
		graph.addEdge(7, 8, 1);
		graph.addEdge(8, 9, 7);
		graph.addEdge(1, 8, 8);
		graph.addEdge(2, 8, 11);
		graph.addEdge(3, 6, 4);
		graph.addEdge(3, 9, 2);
		graph.addEdge(4, 6, 14);
		graph.addEdge(7, 9, 6);

		kruskalMST(graph);
	}

	public static void kruskalMST(Graph graph) {

		Collections.sort(graph.list);

		Edge[] result = new Edge[graph.V];
		int mst = 0;
		int e = 1;
		int idx = 0;

		while (e < graph.V - 1) {

			Edge edge = graph.list.get(idx++);

			if (find(graph.subset, edge.src) != find(graph.subset, edge.dest)) {
				union(graph.subset, edge.src, edge.dest);
				mst += edge.weight;
				result[e++] = edge;
			}
		}
		for (int i = 1; i < e; i++)
			System.out.println((char) (result[i].src - 1 + 'a') + " <-> " + (char) (result[i].dest - 1 + 'a') + " : "
					+ result[i].weight);
		System.out.println("Kruskal MST : " + mst);
	}

	public static int find(Subset[] subset, int u) {

		if (subset[u].parent == u)
			return u;
		else
			return subset[u].parent = find(subset, subset[u].parent);
	}

	public static void union(Subset[] subset, int u, int v) {

		int uRoot = find(subset, u);
		int vRoot = find(subset, v);

		if (uRoot == vRoot)
			return;

		if (subset[uRoot].rank < subset[vRoot].rank)
			subset[uRoot].parent = vRoot;
		else if (subset[uRoot].rank > subset[vRoot].rank)
			subset[vRoot].parent = uRoot;
		else {
			subset[uRoot].parent = vRoot;
			subset[vRoot].rank += 1;
		}
	}
}

class Graph {

	int V;
	List<Edge> list;
	Subset[] subset;

	public Graph(int size) {
		this.V = size + 1;
		list = new ArrayList<>();
		subset = new Subset[V];
		for (int i = 1; i < V; i++) {
			subset[i] = new Subset(i, 0);
		}
	}

	public void addEdge(int src, int dest, int weight) {
		list.add(new Edge(src, dest, weight));
	}
}

class Edge implements Comparable<Edge> {
	int src;
	int dest;
	int weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}

class Subset {
	int parent;
	int rank;

	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}

}