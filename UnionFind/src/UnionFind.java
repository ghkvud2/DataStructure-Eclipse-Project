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
                System.out.print(i + "�� " + j + "�� ���� �׷��ΰ���?  :   ");
                if (find(parent, i, j))
                    System.out.println("��!");
                else
                    System.out.println("�ƴϿ�!");
            }
            System.out.println();
        }
    }
 
    // ������ ��忡 ���� �θ� ��带 ����
    public static int getParent(int[] parent, int node) {
 
        if (parent[node] == node)
            return node;
        else
            return parent[node] = getParent(parent, parent[node]);
    }
 
    // ������ �� ��尡 ���� �׷쿡 ���ϴ��� Ȯ��
    public static boolean find(int[] parent, int node1, int node2) {
 
        int parent1 = getParent(parent, node1);
        int parent2 = getParent(parent, node2);
 
        if (parent1 == parent2)
            return true;
        else
            return false;
    }
 
    //�� ����� �θ��带 ��ħ.
    public static void union(int[] parent, int node1, int node2) {
 
        a = getParent(parent, node1);
        b = getParent(parent, node2);
 
        if(a != b)
	parent[a] = b;
    }
}