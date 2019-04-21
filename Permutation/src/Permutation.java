
public class Permutation {

	static int N = 3;
	static int[] arr = new int[] { 1, 2, 3};
	static int[] result = new int[N];
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) {
		dfs(0);
	}

	public static void dfs(int depth) {

		if (depth == N) {
			for (int i = 0; i < N; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
