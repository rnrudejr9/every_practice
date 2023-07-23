package week5.day7;

import utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * cnt++ 과 cnt + 1 차이
 */
public class P_연구소_답 {
    static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
    static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
    static int originalMap[][];
    static ArrayList<Point> target;
    static int n,m;
    static int maxSafeZone = Integer.MIN_VALUE; //최대값을 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];
        target = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                if(originalMap[i][j] == 2){
                    target.add(new Point(i,j));
                }
            }
        }

        DFS(0);
        System.out.println(answer);
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int Zero(int[][] map){
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    result += 1;
                }
            }
        }
        return  result;
    }
    static int answer= 0;
    public static void BFS(Point[] points, int[][] map){
        Queue<Point> queue = new LinkedList<>();
        for(Point mp : points){
            queue.add(mp);
        }
        while (!queue.isEmpty()){
            Point point = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && map[mx][my] == 0){
                    map[mx][my] = 2;
                    queue.add(new Point(mx,my));
                }
            }
        }
        answer = Math.max(answer,Zero(map));
    }
    public static void DFS(int cnt){
        if(cnt == 3){
            int[][] cloneMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    cloneMap[i][j] = originalMap[i][j];
                }
            }
            BFS(target.toArray(Point[]::new),cloneMap);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(originalMap[i][j] == 0){
                    originalMap[i][j] = 1;
                    DFS(cnt+1);
                    originalMap[i][j] = 0;
                }
            }
        }

    }
}
