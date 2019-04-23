import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	static int N = 5;

	public static void main(String[] args) {

		Graph graph = new Graph(N);
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 5, 10);
		graph.addEdge(2, 5, 3);
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 4, 9);
		graph.addEdge(3, 1, 7);
		graph.addEdge(3, 4, 6);
		graph.addEdge(4, 3, 4);
		graph.addEdge(5, 2, 2);
		graph.addEdge(5, 4, 1);

		dijkstra(graph, 1);

	}

	public static void dijkstra(Graph graph, int start) {

		boolean[] pst = new boolean[graph.size];
		int[] dist = new int[graph.size];
		for (int i = 0; i < graph.size; i++)
			dist[i] = Integer.MAX_VALUE;

		PriorityQueue<Node> q = new PriorityQueue<>();

		dist[start] = 0;
		q.offer(new Node(start, 0));

		while (!q.isEmpty()) {

			Node node = q.poll();
			if (dist[node.node] < node.weight)
				continue;
			pst[node.node] = true;

			for (int i = 0; i < graph.list.get(node.node).size(); i++) {

				Node adj = graph.list.get(node.node).get(i);

				if (!pst[adj.node]) {

					if (dist[adj.node] > dist[node.node] + adj.weight) {
						dist[adj.node] = dist[node.node] + adj.weight;
						q.offer(new Node(adj.node, dist[adj.node]));
					}
				}
			}
		}
		for (int i = 1; i < graph.size; i++) {
			if (i != start)
				System.out.println(start + " -> " + i + " : " + dist[i]);
		}
	}

}

class Graph {
	int size;
	List<List<Node>> list;

	public Graph(int size) {

		this.size = size + 1;
		this.list = new ArrayList<>();

		for (int i = 0; i < this.size; i++) {
			List<Node> item = new ArrayList<>();
			this.list.add(item);
		}
	}

	public void addEdge(int src, int dest, int weight) {
		list.get(src).add(new Node(dest, weight));
	}

}

class Node implements Comparable<Node> {
	int node;
	int weight;

	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

}
