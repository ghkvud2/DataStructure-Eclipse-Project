import static java.lang.String.format;

public class FloydWarshall {

	final static int INF = 100000000;
	static int N;

	static int[][] graph = { { 0, 5, INF, 8 }, { 7, 0, 9, INF }, { 2, INF, 0, 4 }, { INF, INF, 3, 0 }, };

	public static void main(String[] args) {

		N = graph.length;
		int[][] dist = new int[N][N];
		int[][] prev = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = graph[i][j];
				prev[i][j] = -1;
			}
		}

		floydWarshall(dist, prev);
		System.out.println("   pair     dist     path");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					System.out.print("[" + (i + 1) + " -> " + (j + 1) + "]    ");
					System.out.print("[" + dist[i][j] + "]     ");
					System.out.print((i + 1) + " -> ");
					printResult(i, j, prev);
					System.out.println((j + 1));
				}
			}
		}
	}

	public static void floydWarshall(int[][] dist, int[][] prev) {

		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						prev[i][j] = k;
					}
	}

	public static void printResult(int source, int dest, int[][] prev) {

		if (prev[source][dest] == -1)
			return;

		int pNode = prev[source][dest];
		printResult(source, pNode, prev);
		System.out.print((pNode + 1) + " -> ");
		printResult(pNode, dest, prev);
	}
}
