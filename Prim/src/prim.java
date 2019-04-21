import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

// class to represent a node in PriorityQueue
// Stores a vertex and its corresponding
// key value
class LinkedVertex {
	int vertex;
	int key;
}

class Node {

	// Stores destination vertex in adjacency list
	int dest;

	// Stores weight of a vertex in adjacency list
	int weight;

	// Constructor
	Node(int a, int b) {
		dest = a;
		weight = b;
	}
}

class Graph {

	// Number of vertices in the graph
	int V;

	// List of adjacent nodes of a given vertex
	LinkedList<Node>[] adj;

	// Constructor
	Graph(int e) {
		V = e;
		adj = new LinkedList[V];
		for (int o = 0; o < V; o++)
			adj[o] = new LinkedList<>();
	}
}

public class prim {

	// Comparator class created for PriorityQueue
	// returns 1 if node0.key > node1.key
	// returns 0 if node0.key < node1.key and
	// returns -1 otherwise
	class comparator implements Comparator<LinkedVertex> {

		@Override
		public int compare(LinkedVertex node0, LinkedVertex node1) {
			return node0.key - node1.key;
		}
	}

	// method to add an edge
	// between two vertices
	void addEdge(Graph graph, int src, int dest, int weight) {

		Node node0 = new Node(dest, weight);
		Node node = new Node(src, weight);
		graph.adj[src].addLast(node0);
		graph.adj[dest].addLast(node);
	}

	// method used to find the mst
	void prims_mst(Graph graph) {

		// Whether a vertex is in PriorityQueue or not
		Boolean[] mst = new Boolean[graph.V];
		LinkedVertex[] linkedVertex = new LinkedVertex[graph.V];

		// Stores the parents of a vertex
		int[] parent = new int[graph.V];

		for (int o = 0; o < graph.V; o++)
			linkedVertex[o] = new LinkedVertex();

		for (int o = 0; o < graph.V; o++) {

			// Initialize to false
			mst[o] = false;

			// Initialize key values to infinity
			linkedVertex[o].key = Integer.MAX_VALUE;
			linkedVertex[o].vertex = o;
			parent[o] = -1;
		}

		// Include the source vertex in mstset
		mst[0] = true;

		// Set key value to 0
		// so that it is extracted first
		// out of PriorityQueue
		linkedVertex[0].key = 0;

		// PriorityQueue
		PriorityQueue<LinkedVertex> queue = new PriorityQueue<>(graph.V, new comparator());

		for (int o = 0; o < graph.V; o++)
			queue.add(linkedVertex[o]);

		// Loops until the PriorityQueue is not empty
		while (!queue.isEmpty()) {

			// Extracts a node with min key value
			LinkedVertex node0 = queue.poll();
			System.out.println(node0.vertex + "를 집합 Va에 추가한다." + linkedVertex[node0.vertex].key + "이다.");
			// Include that node into mstset
			mst[node0.vertex] = true;

			// For all adjacent vertex of the extracted vertex V
			for (Node adj : graph.adj[node0.vertex]) {

				// If V is in PriorityQueue
				if (mst[adj.dest] == false) {
					// If the key value of the adjacent vertex is
					// more than the extracted key
					// update the key value of adjacent vertex
					// to update first remove and add the updated vertex
					if (linkedVertex[adj.dest].key > adj.weight) {
						queue.remove(linkedVertex[adj.dest]);
						linkedVertex[adj.dest].key = adj.weight;
						queue.add(linkedVertex[adj.dest]);
						parent[adj.dest] = node0.vertex;
					}
				}
			}
		}

		// Prints the vertex pair of mst
		for (int o = 1; o < graph.V; o++)
			System.out.println(parent[o] + " " + "-" + " " + o);
	}

	public static void main(String[] args) {
		int V = 10;

		Graph graph = new Graph(V);

		prim e = new prim();

		e.addEdge(graph,1, 2, 4);
		e.addEdge(graph,2, 3, 8);
		e.addEdge(graph,3, 4, 7);
		e.addEdge(graph,4, 5, 9);
		e.addEdge(graph,5, 6, 10);
		e.addEdge(graph,6, 7, 2);
		e.addEdge(graph,7, 8, 1);
		e.addEdge(graph,8, 9, 7);
		e.addEdge(graph,1, 8, 8);
		e.addEdge(graph,2, 8, 11);
		e.addEdge(graph,3, 6, 4);
		e.addEdge(graph,3, 9, 2);
		e.addEdge(graph,4, 6, 14);
		e.addEdge(graph,7, 9, 6);

		// Method invoked
		e.prims_mst(graph);
	}
}
// This code is contributed by Vikash Kumar Dubey 