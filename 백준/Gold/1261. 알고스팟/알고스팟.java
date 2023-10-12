import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int m, n;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] distance;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		public int cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point p) {
			return Integer.compare(cnt, p.cnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		dijkstra();
		System.out.println(distance[n-1][m-1]);
	}

	public static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		distance[0][0] = 0;
		pq.offer(new Point(0, 0, 0));
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (int i = 0; i < dx.length; i++) {
				int mx = dx[i] + cur.x;
				int my = dy[i] + cur.y;
				int level = cur.cnt;
				if (check(mx, my)) {
					if(map[mx][my] == 1) {
						level++;
					}
					if(distance[mx][my] > level) {
						distance[mx][my] =level;
						pq.offer(new Point(mx,my,level));
					}
				}
			}
		}
	}

	private static boolean check(int mx, int my) {
		return mx >= 0 && mx < n && my >= 0 && my < m;
	}
}