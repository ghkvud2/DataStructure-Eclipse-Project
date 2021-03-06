public class UnionFind {

	static int N = 8;

	public static void main(String[] args) {

		int[] parent = new int[N];
		int[] rank = new int[N];

		init(parent, rank);

		union(parent, rank, 0, 1);
		union(parent, rank, 1, 2);
		union(parent, rank, 2, 3);
		union(parent, rank, 3, 4);

		showParent(parent);

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
			parent[uRoot] = vRoot;
			rank[vRoot] += 1;
		}

	}

	public static int find(int[] parent, int u) {

		if (u == parent[u])
			return u;
		else
			return parent[u] = find(parent, parent[u]);
	}

	public static void showParent(int[] parent) {

		System.out.println("       [각 노드의 부모]");
		for (int i = 0; i < N; i++)
			System.out.print("[" + i + "]");
		System.out.println();

		for (int i = 0; i < N; i++)
			System.out.print(" " + parent[i] + " ");
		System.out.println();
		System.out.println();
	}

	public static void init(int[] parent, int[] rank) {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
}