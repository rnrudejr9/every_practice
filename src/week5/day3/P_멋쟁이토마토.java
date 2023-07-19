package week5.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_멋쟁이토마토 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		map = new int[m][n];
		visited = new boolean[m][n];
		ArrayList<Point> list = new ArrayList<>();
		System.out.println(m + " " + n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = 1;
			}
		}
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 1){
					list.add(new Point(i,j));
				}
			}
		}

		for(Point point : list){
			BFS(point.x,point.y);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
	public static void BFS(int x, int y){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		while(!queue.isEmpty()){
			Point point = queue.poll();
			System.out.println("hello");
			if(visited[point.x][point.y]){
				continue;
			}
			visited[point.x][point.y] = true;
			for (int i = 0; i < dx.length ;i++) {
				int mx = point.x + dx[i];
				int my = point.y + dy[i];
				if(mx >= 0 && mx < m && my >= 0 && my < n && map[mx][my] != -1){
					map[mx][my] += map[x][y] + 1;
					queue.add(new Point(mx,my));
				}
			}
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


}
