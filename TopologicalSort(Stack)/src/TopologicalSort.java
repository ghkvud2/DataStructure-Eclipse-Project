import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	static final int V = 7;
	static Stack<Integer> stack = new Stack<>();
	static List<Integer>[] list = new ArrayList[V + 1];
	static boolean[] finished = new boolean[V + 1];
	static boolean[] visited = new boolean[V + 1];
	static boolean isCycle = false;

	public static void main(String[] args) {

		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<Integer>();

		list[5].add(1);
		list[1].add(2);
		list[1].add(4);
		list[5].add(3);
		list[3].add(4);
		list[4].add(7);
		list[6].add(3);

		for (int i = 1; i <= V; i++) {
			if (!finished[i])
				dfs(i);
		}
		if (isCycle)
			System.out.println("사이클이 있는 그래프입니다.");
		else {
			while (!stack.isEmpty())
				System.out.print(stack.pop() + " ");
		}
	}

	static void dfs(int v) {

		visited[v] = true;
		for (int adj : list[v]) {

			if (!visited[adj])
				dfs(adj);

			else if (!finished[adj])
				isCycle = true;
		}

		finished[v] = true;
		stack.push(v);
	}

}
