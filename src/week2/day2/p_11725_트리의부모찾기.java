package week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
7
1 6
6 3
3 5
4 1
2 4
4 7
 */

/*
4
6
1
3
1
4
*/

// tree 구현
// 짜여진 tree에서 BFS로 순회
// 순회하면서 방문하지 않은 곳 true, 부모 노드에 반영

public class p_11725_트리의부모찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n];
        int[] parentNode = new int[n];

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : tree.get(v))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v;
                }
        }

        for (int i = 1; i < n; i++)
            System.out.println(parentNode[i] + 1);
    }
}
