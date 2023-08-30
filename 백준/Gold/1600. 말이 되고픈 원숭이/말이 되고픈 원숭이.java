import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] hx = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int[] hy = {2, 2, 1, -1, -2, -2, -1, 1};
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[k + 1][n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0][0] = true;
		traking();
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(min);
		}
	}

	static int min = Integer.MAX_VALUE;

	public static void traking() {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0, 0, 0, k});
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int cnt = temp[2];
			int depth = temp[3];

			if (x == n - 1 && y == m - 1) {
				min = Math.min(cnt, min);
				return;
			}
			for (int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (check(mx, my) && !visited[depth][mx][my] && map[mx][my] != 1) {
					visited[depth][mx][my] = true;
					que.offer(new int[] {mx, my, cnt + 1, depth});
				}
			}

			if (depth > 0) {
				for (int j = 0; j < hx.length; j++) {
					int hmx = x + hx[j];
					int hmy = y + hy[j];
					if (check(hmx, hmy) && !visited[depth - 1][hmx][hmy]) {
						if (map[hmx][hmy] == 1)
							continue;
						visited[depth - 1][hmx][hmy] = true;
						que.offer(new int[] {hmx, hmy, cnt + 1, depth - 1});

					}
				}
			}

		}

	}

	private static boolean check(int mx, int my) {
		// TODO Auto-generated method stub
		return mx >= 0 && mx < n && my >= 0 && my < m;
	}

}