package temp;

import java.util.Arrays;
import java.util.Comparator;

public class p_최소비용구하기 {

    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    public static int find(int[] parent, int i) {
        //자기 자신을 가리키니 부모가 맞다.
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {

        int [][]graph = {{1, 2, 6}, {1, 3, 3}, {1, 4, 1}, {2, 5, 4}, {3, 4, 2}, {3, 5, 5}, {4, 5, 7}};
        // 1과 index1을 맞추기 위해 + 1
        int []parent = new int[6];
        //최소 신장트리의 가중치 총 합
        int total = 0;



        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // 가중치 기준으로 정렬
        Arrays.sort(graph,(o1,o2)->o1[1] - o2[1]);
        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }
        System.out.println("최소 비용 신장 트리 가중치의 합은 " + total);
    }
}