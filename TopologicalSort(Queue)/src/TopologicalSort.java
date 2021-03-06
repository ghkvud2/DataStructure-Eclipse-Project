import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	static final int V = 7;
	static List<Integer>[] list = new ArrayList[V + 1];
	static int[] indegree = new int[V + 1];

	public static void main(String[] args) {

		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<Integer>();

		list[5].add(1);
		indegree[1]++;

		list[1].add(2);
		indegree[2]++;

		list[1].add(4);
		indegree[4]++;

		list[5].add(3);
		indegree[3]++;

		list[3].add(4);
		indegree[4]++;

		list[4].add(7);
		indegree[7]++;

		list[6].add(3);
		indegree[3]++;

		topologicalSort();

	}

	static void topologicalSort() {

		Queue<Integer> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		for (int i = 1; i <= V; i++) {

			if (q.isEmpty()) {
				System.out.println("사이클이 있는 그래프입니다.");
				return;
			}

			int node = q.poll();
			result.add(node);

			for (int j = 0; j < list[node].size(); j++) {

				int adj = list[node].get(j);
				indegree[adj] -= 1;

				if (indegree[adj] == 0)
					q.offer(adj);

			}
		}
		for (int node : result)
			System.out.print(node + " ");

	}

}
