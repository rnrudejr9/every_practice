package week9.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 물, 고슴도치, 고슴도치는 물 이동할 수 없다. 물도 비버의 소굴로 이동할 수 없다. 고슴도치가 비버의 굴로 가는
 * 
 * 물이 찰 예정인 칸에 고슴도치는 이동할 수 없다.
 * 
 * 팁) 물과 고슴도치가 갈 수 있는 위치를 조건식으로 주는게 편함
 * 
 * @author SSAFY
 *
 */
public class 백준_탈출_3055 {
	static char[][] map;
	static Queue<int[]> que;
	static int endX;
	static int endY;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		que = new LinkedList<>();
		int startX = 0;
		int startY = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
				if (map[i][j] == 'D') {
					endX = i;
					endY = j;
				}
				if (map[i][j] == '*') {
					que.add(new int[] { i, j, 0, -1 });
				}
			}
		}
		que.add(new int[] { startX, startY, 0, 0 });

		int ans = play();
		if(ans == -1 )
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
	}

	public static int play() {
		while (!que.isEmpty()) {

			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int depth = temp[2];
			int type = temp[3]; // -1 물 : 0 고슴도치
			if (x == endX && y == endY && type == 0) {
				return depth;
			}
			if (type == -1) {
				for (int i = 0; i < dx.length; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (check(mx, my)) {
						if (map[mx][my] == 'S' || map[mx][my] == '.') {
							map[mx][my] = '*';
							que.add(new int[] { mx, my, 0, -1 });
						}
					}
				}
			}
			if (type == 0) {
				for (int i = 0; i < dx.length; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (check(mx, my)) {
						// && (map[mx][my] == '.' || map[mx][my] == 'D')
						// 갈 수 있는 위치로 조건식 변경
						if (map[mx][my] == '.' || map[mx][my] == 'D') {
							map[mx][my] = 'S';
							que.add(new int[] { mx, my, depth + 1, 0 });
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean check(int mx, int my) {
		// TODO Auto-generated method stub
		return mx >= 0 && mx < n && my >= 0 && my < m;
	}
}
