package week4.day7;

import java.util.Scanner;

/**
 * n x n 배열 전 구역 탐색
 * 0,0 부터 n,n 까지의 가는 모든 경우의수를 체크 할 수 있을까
 *
 * 결론 : 무한루프에 빠짐, 원치않은 결과가 나옴
 */
public class p_DFS_예제테스트 {
    static int n;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static StringBuilder sb;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        sb = new StringBuilder();

        DFS(0,0);
    }

    public static void DFS(int x,int y){
        if(x == n-1 && y == n-1){
            sb.append("[" + x +", "+ y + "]");
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }
        sb.append("[" + x +", "+ y + "]" + " ->");
        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx >= 0 && mx < n && my >= 0 && my < n){
                if(!visited[mx][my]){
                    visited[mx][my] = true;
                    DFS(mx,my);
                    visited[mx][my] = false;
                }
            }
        }
    }
}
