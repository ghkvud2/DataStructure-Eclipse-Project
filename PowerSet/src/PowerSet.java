
public class PowerSet {

	static int N = 4;
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		dfs(0, arr);
	}

	public static void dfs(int depth, int[] arr) {

		if (depth == 4) {

			for (int i = 0; i < 4; i++)
				if (visited[i])
					System.out.print(arr[i] + " ");
			System.out.println();

			return;
		}

		visited[depth] = false;
		dfs(depth + 1, arr);

		visited[depth] = true;
		dfs(depth + 1, arr);

	}
}
