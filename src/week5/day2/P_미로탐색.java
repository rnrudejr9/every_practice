package week5.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_미로탐색 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n;i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        BFS(0,0);

        System.out.println(map[n-1][m-1]);




    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x,y));

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            visited[temp.x][temp.y]= true;
            for (int j = 0; j < dx.length; j++) {
                int mx = temp.x + dx[j];
                int my = temp.y + dy[j];
                if(mx >= 0 && mx < n && my >= 0 && my < m && !visited[mx][my] && map[mx][my] == 1) {
                    queue.add(new Point(mx,my));
                    map[mx][my] = map[temp.x][temp.y]+ 1;
                }

            }


        }
    }


}