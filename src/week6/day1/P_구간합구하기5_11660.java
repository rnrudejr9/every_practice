package week6.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_구간합구하기5_11660{
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static int x1;
    static int y1;
    static boolean[][] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb;
        for (int i = 0; i < m; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n+1][n+1];
            result = 0;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            BFS(new Point(x1,y1), new Point(x2,y2));
            sb.append(result);
            System.out.println(sb.toString());
        }
    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(Point start, Point end){
        Queue<Point> queue = new LinkedList();
        queue.add(start);
        result += arr[start.x][start.y];
        while (!queue.isEmpty()){
            Point poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int mx = poll.x + dx[i];
                int my = poll.y + dy[i];
                if(mx >= x1 && mx <= end.x && my >= y1 && my <= end.y && !visited[mx][my]){
                    visited[mx][my] = true;
                    result += arr[mx][my];
                    queue.add(new Point(mx,my));
                }
            }
        }
    }

}
