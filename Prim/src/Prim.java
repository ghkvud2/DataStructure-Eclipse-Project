import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	static int N = 9;

	public static void main(String[] args) {

		Graph graph = new Graph(N + 1);
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

		getMST(graph, N + 1);
	}

	public static void getMST(Graph graph, int size) {

		boolean[] mst = new boolean[size];
		LinkedVertex[] linkedVertex = new LinkedVertex[size];
		PriorityQueue<LinkedVertex> q = new PriorityQueue<>();

		for (int i = 1; i < size; i++)
			linkedVertex[i] = new LinkedVertex(i, -1, Integer.MAX_VALUE);

		linkedVertex[1].parent = 1;
		linkedVertex[1].key = 0;
		mst[1] = true;

		for (int i = 1; i < size; i++)
			q.offer(linkedVertex[i]);

		int sum = 0;
		while (!q.isEmpty()) {

			LinkedVertex vertex = q.poll();
			mst[vertex.vertex] = true;
			sum += vertex.key;

			for (int i = 0; i < graph.adj[vertex.vertex].size(); i++) {

				Node adj = graph.adj[vertex.vertex].get(i);

				if (!mst[adj.dest]) {

					if (adj.weight < linkedVertex[adj.dest].key) {
						q.remove(linkedVertex[adj.dest]);
						linkedVertex[adj.dest].key = adj.weight;
						linkedVertex[adj.dest].parent = vertex.vertex;
						q.offer(linkedVertex[adj.dest]);
					}
				}
			}
		}
		for (int i = 1; i < size; i++)
			System.out.println(linkedVertex[i].vertex + " - " + linkedVertex[i].parent);

		System.out.println("MST Value : " + sum);
	}
}

class Graph {

	List<Node>[] adj;

	public Graph(int size) {

		this.adj = new ArrayList[size];

		for (int i = 0; i < size; i++)
			adj[i] = new ArrayList<>();
	}

	public void addEdge(int src, int dest, int weight) {

		Node from = new Node(src, weight);
		Node to = new Node(dest, weight);

		adj[src].add(to);
		adj[dest].add(from);
	}
}

class Node {
	int dest;
	int weight;

	public Node(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
}

class LinkedVertex implements Comparable<LinkedVertex> {

	int vertex;
	int parent;
	int key;

	public LinkedVertex(int vertex, int parent, int key) {
		this.vertex = vertex;
		this.parent = parent;
		this.key = key;
	}

	@Override
	public int compareTo(LinkedVertex o) {
		if (this.key < o.key)
			return -1;
		else if (this.key == o.key) {

			return this.vertex - o.vertex;

		} else
			return 1;
	}
}
