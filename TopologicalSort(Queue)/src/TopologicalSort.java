import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

	static final int V = 7;
	static List<Integer>[] list = new ArrayList[V + 1];
	
	public static void main(String[] args) {
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<Integer>();
	}
}
