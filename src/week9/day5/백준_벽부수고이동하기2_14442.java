package week9.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 시간초과 : 다음 visited에 대한 데이터식을 변경
 * 
 * visited[life][mx][my] = true; 조건 식 하나 안해줘서 시간 초과 발생.
 * 
 * 메모리 : 348088 KB
 * 속도 : 3008 ms
 * 
 * @author SSAFY
 *
 */
public class 백준_벽부수고이동하기2_14442 {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static Queue<int[]> que;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[k+1][n][m];
		que = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited[0][0][0] = true;
		que.add(new int[] {0,0,0,0});
		BFS();
	}
	public static void BFS() {
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int life = temp[2];
			int depth = temp[3];

			if(x == n-1 && y == m-1) {
				System.out.println(depth + 1);
				return;
			}
			for (int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(check(mx,my)) {
					if(map[mx][my] == 0 && !visited[life][mx][my]) {
						visited[life][mx][my] = true;
						que.add(new int[] {mx,my,life,depth+1});
					}
					if(map[mx][my] == 1 && !visited[life][mx][my] && life != k) {
						//왜 이거 빼면 시간초과 나는가?... 흑흑..
						visited[life][mx][my] = true;
						visited[life + 1][mx][my] = !visited[life][x][y];
						que.add(new int[] {mx,my,life + 1,depth+1});
					}
				}
			}
		}
		System.out.println(-1);
	}
	private static boolean check(int mx, int my) {
		// TODO Auto-generated method stub
		return mx >= 0 && mx < n && my >= 0 && my < m;
	}
}
