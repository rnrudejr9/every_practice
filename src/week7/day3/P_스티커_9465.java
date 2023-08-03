package week7.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_스티커_9465 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] fx = {-1,1,1,-1};
    static int[] fy = {1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            visited = new boolean[2][n];
            for (int t = 0; t < 2; t++) {
                StringTokenizer st=  new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[t][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int t = 0; t < 2; t++) {
                for (int j = 0; j < n; j++) {
                    perm(i,j,0);
                }
            }
            System.out.println(result);

        }
    }
    static int result = Integer.MAX_VALUE;
    public static void perm(int x,int y,int value){
        if(isAll()){
            result = Math.min(value, result);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            int rx = x + fx[i];
            int ry = y + fy[i];
            if (mx >= 0 && mx < 2 && my >= 0 && my < n && !visited[mx][my]) {
                visited[mx][my] = true;
                if (rx >= 0 && rx < 2 && ry >= 0 && ry < n && !visited[rx][ry]) {
                    visited[rx][ry] = true;
                    perm(rx, ry,value+arr[x][y]);
                    visited[rx][ry] = false;
                }
                visited[mx][my] = false;
            }
        }


    }

    private static boolean isAll() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
