import java.util.PriorityQueue;
import javax.xml.transform.URIResolver;

public class Kruskal {

	static int N = 9;

	public static void main(String[] args) {

		PriorityQueue<Edge> q = new PriorityQueue<>();
		int[] parent = new int[N + 1];
		int[] rank = new int[N + 1];

		init(parent, rank);

		q.offer(new Edge(1, 2, 4));
		q.offer(new Edge(2, 3, 8));
		q.offer(new Edge(3, 4, 7));
		q.offer(new Edge(4, 5, 9));
		q.offer(new Edge(5, 6, 10));
		q.offer(new Edge(6, 7, 2));
		q.offer(new Edge(7, 8, 1));
		q.offer(new Edge(8, 9, 7));
		q.offer(new Edge(1, 8, 8));
		q.offer(new Edge(2, 8, 11));
		q.offer(new Edge(3, 6, 4));
		q.offer(new Edge(3, 9, 2));
		q.offer(new Edge(4, 6, 14));
		q.offer(new Edge(7, 9, 6));
		
		int sum = 0;
		while (!q.isEmpty()) {
			Edge edge = q.poll();
			if (find(parent, edge.u) != find(parent, edge.v)) {
				union(parent, rank, edge.u, edge.v);
				sum += edge.weight;
			}
		}
		System.out.println(sum);
	}

	public static void union(int[] parent, int[] rank, int u, int v) {

		int uRoot = find(parent, u);
		int vRoot = find(parent, v);

		if (uRoot == vRoot)
			return;

		int uRank = rank[uRoot];
		int vRank = rank[vRoot];

		if (uRank < vRank)
			parent[uRoot] = vRoot;
		else if (uRank > vRank)
			parent[vRoot] = uRoot;
		else {
			parent[vRoot] = uRoot;
			rank[uRoot] += 1;
		}
	}

	public static int find(int[] parent, int u) {

		if (parent[u] == u)
			return u;
		else
			return parent[u] = find(parent, parent[u]);
	}

	public static void init(int[] parent, int[] rank) {
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

}

class Edge implements Comparable<Edge> {

	int u;
	int v;
	int weight;

	public Edge(int u, int v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}