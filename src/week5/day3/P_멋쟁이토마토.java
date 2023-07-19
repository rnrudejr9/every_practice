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
	static ArrayList<Point> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		map = new int[m][n];
		visited = new boolean[m][n];
		list = new ArrayList<>();
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

		BFS();
//		왜 다른게
	
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}else {
					result = Math.max(result, map[i][j]);
				}
			}
		}
		
		System.out.println(result - 1);

	}
	public static void BFS(){
		Queue<Point> queue = new LinkedList<>();
		for(Point point : list){
			queue.add(point);			
		}
		while(!queue.isEmpty()){
			Point point = queue.poll();
			if(visited[point.x][point.y]){
				continue;
			}
			visited[point.x][point.y] = true;
			for (int i = 0; i < dx.length ;i++) {
				int mx = point.x + dx[i];
				int my = point.y + dy[i];
				if(mx >= 0 && mx < m && my >= 0 && my < n && map[mx][my] != -1){
					if(map[mx][my] == 0) {
						map[mx][my] = map[point.x][point.y] + 1; 
						queue.add(new Point(mx,my));	
					}
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