import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

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

		mst(graph);

	}

	public static void mst(Graph graph) {

		boolean[] mst = new boolean[graph.size];
		Vertex[] ver = new Vertex[graph.size];
		PriorityQueue<Vertex> q = new PriorityQueue<>();

		for (int i = 1; i < graph.size; i++)
			ver[i] = new Vertex(i, -1, Integer.MAX_VALUE);

		ver[1].key = 0;
		ver[1].parent = 1;

		for (int i = 1; i < graph.size; i++)
			q.offer(ver[i]);

		int sum = 0;
		while (!q.isEmpty()) {

			Vertex vertex = q.poll();
			mst[vertex.vertex] = true;
			sum += vertex.key;

			for (int i = 0; i < graph.adj.get(vertex.vertex).size(); i++) {

				Node adj = graph.adj.get(vertex.vertex).get(i);

				if (!mst[adj.node]) {

					if (ver[adj.node].key > adj.weight) {
						q.remove(ver[adj.node]);
						ver[adj.node].key = adj.weight;
						ver[adj.node].parent = vertex.vertex;
						q.add(ver[adj.node]);
					}
				}
			}
		}
		for (int i = 1; i < graph.size; i++)
			System.out.println(ver[i].parent + " -> " + i);
		System.out.println("MST : " + sum);
	}
}

class Graph {

	int size;
	List<List<Node>> adj;

	public Graph(int size) {
		this.size = size + 1;
		adj = new ArrayList<>();

		for (int i = 0; i < this.size; i++) {
			List<Node> list = new ArrayList<>();
			adj.add(list);
		}
	}

	public void addEdge(int source, int dest, int weight) {
		adj.get(source).add(new Node(dest, weight));
		adj.get(dest).add(new Node(source, weight));
	}
}

class Vertex implements Comparable<Vertex> {
	int vertex;
	int parent;
	int key;

	public Vertex(int vertex, int parent, int key) {
		this.vertex = vertex;
		this.parent = parent;
		this.key = key;
	}

	@Override
	public int compareTo(Vertex o) {
		if (this.key < o.key)
			return -1;
		else if (this.key == o.key) {

			return this.vertex - o.vertex;

		} else
			return 1;
	}

}

class Node {
	int node;
	int weight;

	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}
