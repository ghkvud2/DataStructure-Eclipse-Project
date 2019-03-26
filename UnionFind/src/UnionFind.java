public class UnionFind {
 
    public static void main(String[] args) {
 
        int[] parent = new int[7];
        for (int i = 1; i < 7; i++)
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
 
    // 임의의 노드에 대해 부모 노드를 구함
    public static int getParent(int[] parent, int node) {
 
        if (parent[node] == node)
            return node;
        else
            return parent[node] = getParent(parent, parent[node]);
    }
 
    // 임의의 두 노드가 같은 그룹에 속하는지 확인
    public static boolean find(int[] parent, int node1, int node2) {
 
        int parent1 = getParent(parent, node1);
        int parent2 = getParent(parent, node2);
 
        if (parent1 == parent2)
            return true;
        else
            return false;
    }
 
    //두 노드의 부모노드를 합침.
    public static void union(int[] parent, int node1, int node2) {
 
        a = getParent(parent, node1);
        b = getParent(parent, node2);
 
        if(a != b)
	parent[a] = b;
    }
}