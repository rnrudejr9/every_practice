package week5.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_Z {
	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int r= Integer.parseInt(str[1]);
		int c= Integer.parseInt(str[2]);
		int size = (int) Math.pow(2, n);
		map = new int[size][size];
		
		int count = (int) Math.pow(2, n-1);
		
		for(int i = 1; i<=count;i++) {
			zFlip(0,0);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	static int data = 2;	
	public static void zFlip(int x,int y) {
		for (int i = 0; i < dx.length; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(mx >= 0 && mx < map.length && my >= 0 && my < map.length) {
				map[mx][my] = data;
				++data;
			}
		}
	}
}
