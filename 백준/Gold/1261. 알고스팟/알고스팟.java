import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 참고
 * 메모리초과
 * 
 * @author SSAFY
 *
 */
public class Main {
	static int m, n;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	static class Point {
		int x;
		int y;
		public int cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int ans = BFS();
		System.out.println(ans);
	}

	public static int BFS() {
		PriorityQueue<Point> que = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cnt, e2.cnt));
		que.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while (!que.isEmpty()) {
			Point p = que.poll();
			int x = p.x;
			int y = p.y;
			int level = p.cnt;

			if (x == n - 1 && y == m - 1) {
				return level;
			}

			for (int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (check(mx, my)) {
					if (!visited[mx][my]) {
						visited[mx][my] = true;
						if (map[mx][my] == 1) {
							que.offer(new Point(mx, my, level + 1));
						} else {
							que.offer(new Point(mx, my, level));
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean check(int mx, int my) {
		return mx >= 0 && mx < n && my >= 0 && my < m;
	}
}