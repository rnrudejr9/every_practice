package week5.day4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_토마토_7569 {
    static int n;
    static int m;
    static int h;
    static int[][][] map;
    static boolean[][][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] dz = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        h = Integer.parseInt(temp[2]);
        map = new int[h][m][n];
        visited = new boolean[h][m][n];
        ArrayList<Point> pList = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    map[i][j][k] = Integer.parseInt(s[k]);
                    if(map[i][j][k] == 1){
                        pList.add(new Point(j,k,i));
                    }
                }
            }
        }

        BFS(pList);

        int result = -1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if(map[i][j][k] > result){
                        result = map[i][j][k];
                    }
                }
            }
        }
        System.out.println(result - 1);
    }


    public static void BFS(ArrayList<Point> point){
        Queue<Point> queue = new LinkedList<>();
        for(Point list : point){
            queue.add(list);
        }
        while(!queue.isEmpty()){
            Point poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int z = poll.z;
            if(visited[z][x][y]){
                continue;
            }
            visited[z][x][y] = true;

            for(int i = 0;i<dx.length;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx >= 0 && mx < m && my >= 0 && my < n && map[z][mx][my] != -1 && map[z][mx][my] == 0){
                    map[z][mx][my] = map[z][x][y] + 1;
                    queue.add(new Point(mx,my,z));
                }
            }
            for (int i = 0; i < dz.length; i++) {
                int mz = z + dz[i];
                if(mz >= 0 && mz < h && map[mz][x][y] == 0 && map[mz][x][y] != -1){
                    map[mz][x][y] = map[z][x][y] + 1;
                    queue.add(new Point(x,y,mz));
                }
            }
        }

    }
    static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
