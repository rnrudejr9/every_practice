package week4.day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * DFS 로 풀려다가 시간오류 + 성능문제로 인한 이슈
 * DP 배열 + BFS 를 통해서 해결 할 수 있다.
 *
 * 누적합 또는 DP 배열
 */
public class p_보급로 {
    static int n;
    static Integer[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            min = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            map = new Integer[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < str.length; j++) {
                    map[i][j] = Integer.parseInt(str[i]);
                }
            }
            BFS(0,0,0);
            System.out.println(min);
        }
    }
    public static void DFS(int x,int y,int value){
        if(x == n-1 && y == n-1 ){
            min = Math.min(min,value);
            return;
        }
        if(value > min ){
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(!(mx < 0 || mx >= n || my < 0 || my >= n)){
                if(!visited[mx][my]) {
                    visited[mx][my] = true;
                    DFS(mx, my, value + map[x][y]);
                    visited[mx][my] = false;
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;

        }
    }
    public static void BFS(int x,int y,int value){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,0));
        visited[x][y] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nx = node.x;
            int ny = node.y;
            if(nx == n-1 && ny == n-1){
                min = Math.min(min,node.cost);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int mx = node.x + dx[i];
                int my = node.y + dy[i];
                if((mx >= 0 && mx < n && my >= 0 && my < n) && !visited[mx][my]){
                    visited[mx][my] =true;
                    queue.offer(new Node(mx,my, value + map[node.x][node.y]));
                }
            }

        }
    }
}
