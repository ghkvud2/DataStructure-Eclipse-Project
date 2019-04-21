
public class Disjoint {

	static int N = 10;

	public static void main(String[] args) {

		int[] parent = new int[N];
		int[] rank = new int[N];

		init(parent, rank);

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
			rank[vRoot] += 1;
		}
	}

	public static int find(int[] parent, int u) {
		if (parent[u] == u)
			return u;
		else
			return parent[u] = find(parent, parent[u]);
	}

	public static void init(int[] parent, int[] rank) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
}
