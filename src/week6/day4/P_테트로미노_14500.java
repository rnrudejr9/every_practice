package week6.day4;

import utils.PrintUtils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_테트로미노_14500 {
    static int[][] map;
    static int n;
    static int m;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int result = 0;
    static int dfs_data = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                DFS(i,j,0,map[i][j]);
                BFS(i,j);
                visited[i][j] = false;
            }
        }
        int max = Math.max(result, dfs_data);
        System.out.println(max);

    }
    public static void DFS(int x,int y,int depth,int value){

        if(depth == 3){
            if(result < value){
                result = Math.max(value, result);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx >= 0 && mx < n && my >= 0 && my < m && !visited[mx][my]){
                visited[mx][my] = true;
                DFS(mx,my,depth+1, value+map[mx][my]);
                visited[mx][my] = false;
            }
        }
    }

    public static void BFS(int x,int y){
        int index = 0;
        for (int j = 0; j< 4; j++) {
            int value = map[x][y];
            for (int i = 0; i < 3; i++) {
                index %= 4;
                int mx = x + dx[index];
                int my = y + dy[index];
                if (mx >= 0 && mx < n && my >= 0 && my < m) {
                    value += map[mx][my];
                }
                index += 1;
            }

            dfs_data = Math.max(dfs_data, value);
        }
    }
}
