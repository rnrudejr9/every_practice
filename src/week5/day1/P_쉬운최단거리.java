package week5.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_쉬운최단거리 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        int tempX = -1;
        int tempY = -1;
        for(int i = 0 ; i<n;i++){
            String[] str=br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 2){
                    tempX = i;
                    tempY = j;
                }
            }
        }

        BFS(tempX,tempY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static class XY{
        int x;
        int y;
        int value;

        public XY(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int value = 0;
    public static void BFS(int x,int y){
        Queue<XY> queue = new LinkedList();
        XY xys = new XY(x, y, 0);
        queue.offer(xys);
        visited[xys.x][xys.y] = true;

        while(!queue.isEmpty()){
            XY xy = queue.poll();
            result[xy.x][xy.y] = xy.value;
            for (int i = 0; i < dx.length; i++) {
                int mx = xy.x + dx[i];
                int my = xy.y + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && !visited[mx][my]){
                    if(map[mx][my] == 0){
                        visited[mx][my] = true;
                        continue;
                    }
                    visited[mx][my] = true;
                    queue.offer(new XY(mx,my,xy.value + 1));
                }
            }
        }
    }
}
