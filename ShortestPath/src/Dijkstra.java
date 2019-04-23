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

		dijkstra(graph.adj, 1);
	}

	public static void dijkstra(List<List<Node>> adj, int source) {

		int[] dist = new int[adj.size()];
		boolean[] spt = new boolean[adj.size()];
		PriorityQueue<Node> q = new PriorityQueue<>();

		for (int i = 1; i < adj.size(); i++)
			dist[i] = Integer.MAX_VALUE;

		dist[source] = 0;
		q.offer(new Node(source, 0));

		while (!q.isEmpty()) {

			Node node = q.poll();
			if (dist[node.node] < node.weight)
				continue;
			spt[node.node] = true;

			for (int i = 0; i < adj.get(node.node).size(); i++) {

				Node adjNode = adj.get(node.node).get(i);

				if (!spt[adjNode.node]) {

					if (dist[node.node] + adjNode.weight < dist[adjNode.node]) {
						dist[adjNode.node] = dist[node.node] + adjNode.weight;
						q.offer(new Node(adjNode.node, dist[adjNode.node]));
					}
				}
			}
		}
		
		for (int i = 1; i < adj.size(); i++) {
			System.out.println(source + " -> " + i + " : " + dist[i]);
		}
	}
}

class Graph {

	int size;
	List<List<Node>> adj = new ArrayList<>();

	public Graph(int size) {

		this.size = size + 1;
		this.adj = new ArrayList<>();

		for (int i = 0; i < this.size; i++) {
			List<Node> list = new ArrayList<>();
			adj.add(list);
		}
	}

	public void addEdge(int src, int dest, int weight) {
		adj.get(src).add(new Node(dest, weight));
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