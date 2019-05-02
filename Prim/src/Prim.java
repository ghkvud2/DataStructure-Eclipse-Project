import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	static class Node {
		int dest;
		int weight;

		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Node2 implements Comparable<Node2> {
		int key;
		int node;
		int prev;

		public Node2(int key, int node, int prev) {
			this.key = key;
			this.node = node;
			this.prev = prev;
		}

		public int compareTo(Node2 o) {
			if (this.key < o.key)
				return -1;
			else if (this.key == o.key) {

				return this.node - o.node;

			} else
				return 1;
		}
	}

	int size;
	Node2[] status;
	List<List<Node>> list;

	public Prim(int size) {

		this.size = size + 1;
		status = new Node2[this.size];
		list = new ArrayList<>();

		for (int i = 0; i < this.size; i++) {
			status[i] = new Node2(Integer.MAX_VALUE, i, -1);
			List<Node> item = new ArrayList<>();
			list.add(item);
		}
	}

	public void addEdge(int src, int dest, int weight) {
		list.get(src).add(new Node(dest, weight));
		list.get(dest).add(new Node(src, weight));
	}

	public void primMST(int start) {

		int sum = 0;
		status[start].key = 0;
		status[start].prev = 0;

		boolean[] mst = new boolean[this.size];
		PriorityQueue<Node2> q = new PriorityQueue<>();

		for (int i = 1; i < this.size; i++)
			q.offer(status[i]);

		while (!q.isEmpty()) {

			Node2 node = q.poll();
			mst[node.node] = true;
			sum += node.key;

			for (int i = 0; i < list.get(node.node).size(); i++) {

				Node adj = list.get(node.node).get(i);

				if (!mst[adj.dest]) {
					if (status[adj.dest].key > adj.weight) {
						q.remove(status[adj.dest]);
						status[adj.dest].key = adj.weight;
						status[adj.dest].prev = node.node;
						q.add(status[adj.dest]);
					}
				}
			}
		}
		for (int i = 1; i < this.size; i++) {
			if (i != start)
				System.out.println((char) (status[i].prev - 1 + 'a') + " -> " + (char) (i - 1 + 'a'));
		}
		System.out.println("Prim MST : " + sum);
	}

	public static void main(String[] args) {
		Prim prim = new Prim(9);
		prim.addEdge(1, 2, 4);
		prim.addEdge(2, 3, 8);
		prim.addEdge(3, 4, 7);
		prim.addEdge(4, 5, 9);
		prim.addEdge(5, 6, 10);
		prim.addEdge(6, 7, 2);
		prim.addEdge(7, 8, 1);
		prim.addEdge(8, 9, 7);
		prim.addEdge(1, 8, 8);
		prim.addEdge(2, 8, 11);
		prim.addEdge(3, 6, 4);
		prim.addEdge(3, 9, 2);
		prim.addEdge(4, 6, 14);
		prim.addEdge(7, 9, 6);

		prim.primMST(1);
	}

}
