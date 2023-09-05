package week12.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import utils.PrintUtils;

public class P_미로만들기_2665 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		PrintUtils.print2Array(map);
		start();
		System.out.println(ans);
	}

	public static void start(){
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[]{0,0,0});
		visited[0][0] = true;
		while(!que.isEmpty()){
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int value = temp[2];
			System.out.println(x + " " +y);
			if(x == n-1 && y == n-1){
				ans = Math.min(value,ans);
				continue;
			}

			for (int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(check(mx,my)){
					if(visited[mx][my])
						continue;
					visited[mx][my] = true;
					if(map[mx][my]==0){
						value++;
					}
					que.offer(new int[]{mx,my,value});
				}
			}
		}
	}

	private static boolean check(int mx, int my) {
		return mx >= 0 && mx < n && my >= 0 && my < n;
	}
}
