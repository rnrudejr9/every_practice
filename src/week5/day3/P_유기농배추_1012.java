package week5.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_유기농배추_1012 {

	static int n;
    static int m;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] temp = br.readLine().split(" ");
			ArrayList<Point> list = new ArrayList<>();
			m = Integer.parseInt(temp[0]);
			n = Integer.parseInt(temp[1]);
			k = Integer.parseInt(temp[2]);
			map = new int[m][n];
			visited = new boolean[m][n];
			StringTokenizer st;
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int tempX = Integer.parseInt(st.nextToken());
				int tempY = Integer.parseInt(st.nextToken());
				map[tempX][tempY] = 1;
				list.add(new Point(tempX,tempY));
			}
			
			int result = 0;
			for(Point points : list) {
				int x = points.x;
				int y = points.y;
				if(!visited[x][y]) {
					result += 1;
					DFS(x,y);
				}
			}
			System.out.println(result);
		}
		
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
	public static void DFS(int x,int y) {
		for (int i = 0; i < dx.length; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(mx >= 0 && mx < m && my >= 0 && my < n && !visited[mx][my] && map[mx][my] == 1) {
				visited[mx][my] = true;
				DFS(mx,my);
			}
		}
	}
	
	


}
