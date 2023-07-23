package week5.day7;

import utils.PrintUtils;

import javax.swing.text.View;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.lang.reflect.Array;
import java.util.*;

//값을 새로해서 보내고싶다

/**
 * 접근의 한계
 * 1. 2의 위치를 파악해서
 * 2. 2주변의 위치를 리스트 저장
 * 3. 주변 경우의수를 조합으로 선정
 * 4. 조합된 경우의수를 통해 BFS 순회
 * 한계 : 0이 생존할 최대의 경우의 수를 구하는 것인데 잘못함
 * 가능성을 낮게 보고함
 */

public class P_연구소_14502 {
    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] clone = new int[n][m];


        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                clone[i][j] = map[i][j];
            }
        }
        ArrayList<Point> arrayList = getList(list, map);
//        for(Point x : arrayList){
//            System.out.println(x.toString());
//        }

        boolean[] visited = new boolean[arrayList.size()];
        if (arrayList.size() > 3) {
            makeBlock(arrayList, 0, visited, clone,3);
        }


    }

    public static void DFS(int[][] map ){
        Queue<Point> queue = new LinkedList<>();
        for (Point two : list){
            queue.add(two);
        }
        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int mx = temp.x + dx[i];
                int my = temp.y + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && map[mx][my] == 0){
                    map[mx][my] = 2;
                    queue.add(new Point(mx,my));
                }
            }
        }
        PrintUtils.print2Array(map);

    }
    public static void makeBlock(ArrayList<Point> list, int index, boolean[] visited, int[][] map, int r) {
        if (r == 0) {

            ArrayList<Point> now = new ArrayList<>();
            int[][] dfsMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dfsMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if(visited[i]){
                    now.add(list.get(i));
                }
            }
            for(Point mp : now){
                dfsMap[mp.x][mp.y] = 1;
            }
            DFS(dfsMap);
            return;
            // point로 맵 쌓고 BFS
        }
        for (int i = index; i < list.size(); i++) {
            visited[i] = true;
            makeBlock(list, i + 1, visited, map, r-1);
            visited[i] = false;
        }
    }

    public static ArrayList<Point> getList(ArrayList<Point> list, int[][] map) {
        ArrayList<Point> result = new ArrayList<>();
        for (Point point : list) {
            int x = point.x;
            int y = point.y;
            for (int i = 0; i < dx.length; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && map[mx][my] != 2 && map[mx][my] != 1) {
                    map[mx][my] = 1;
                    result.add(new Point(mx, my));
                }
            }
        }
        return result;
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
