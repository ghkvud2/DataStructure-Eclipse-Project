
public class UnionFind {

	public static void main(String[] args) {

		int N = 7;
		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		union(parent, 1, 2);
		union(parent, 2, 5);
		union(parent, 3, 4);
		union(parent, 3, 6);

		for (int i = 1; i < 6; i++) {
			for (int j = i + 1; j < 7; j++) {
				System.out.print(i + "와 " + j + "은 같은 그룹인가요?  :   ");
				if (find(parent, i, j))
					System.out.println("네!");
				else
					System.out.println("아니오!");
			}
			System.out.println();
		}
	}

	public static boolean find(int[] parent, int a, int b) {

		if (getParent(parent, a) == getParent(parent, b))
			return true;
		else
			return false;
	}

	public static int getParent(int[] parent, int a) {
		if (a == parent[a])
			return a;
		else
			return parent[a] = getParent(parent, parent[a]);
	}

	public static void union(int[] parent, int a, int b) {

		a = getParent(parent, a);
		b = getParent(parent, b);

		if (a != b) {
			parent[b] = a;
		}
	}

}
