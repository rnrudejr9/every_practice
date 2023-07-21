package week5.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import utils.PrintUtils;

public class P_정수삼각형_1932 {
	static int[] dx = {1,1};
	static int[] dy = {0,1};
	static int[][] result;
	static boolean[][] visited;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		visited = new boolean[n][n];
		result = new int[n][n];
		
		
		
		for (int i = 0; i < arr.length; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		BFS(new Point(0,0,arr[0][0]), arr);
		
		int answer = 0;
		for (int i = 0; i < arr[n-1].length; i++) {
			answer = Math.max(arr[n-1][i], answer);
		}
		
		PrintUtils.print2Array(result);
		System.out.println(answer);
		
	}
	static class Point{
		int x;
		int y;
		int value;
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
	}
	public static void BFS(Point point, int[][] arr) {
		Queue<Point> queue = new LinkedList();
		queue.add(point);
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int value = p.value;
			
			arr[x][y] = Math.max(value, result[x][y]);
			result[x][y] = Math.max(value, result[x][y]);
			if(visited[x][y]) {
				continue;
			}
			visited[x][y] = true;
			
			for (int i = 0; i < 2; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(mx >= 0 && mx < n && my >= 0 && my < n) {
					queue.add(new Point(mx,my,arr[x][y] + arr[mx][my]));
				}
			}
		}
	}
}
