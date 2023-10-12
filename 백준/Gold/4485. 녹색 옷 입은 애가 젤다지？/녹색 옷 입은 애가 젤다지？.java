import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int cmd;
	static final int INF = Integer.MAX_VALUE / 1000;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int w;
		public Point(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(w, o.w);
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 0;
		while(true) {
			test_case++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			
			map = new int[cmd][cmd];
			distance = new int[cmd][cmd];
			if(cmd == 0) {
				break;
			}
			for (int i = 0; i < cmd; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cmd; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
				Arrays.fill(distance[i], INF);
			}
			System.out.println("Problem " + test_case + ": "+ dijkstra());
		
		}
	}
	public static int dijkstra() {
		visited= new boolean[cmd][cmd];
		distance[0][0] = map[0][0];
		
		PriorityQueue<Point> que = new PriorityQueue<>();
		que.offer(new Point(0, 0, 0));
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(visited[cur.x][cur.y])
				continue;
			visited[cur.x][cur.y] = true;
			for (int i = 0; i < dx.length; i++) {
				int mx = cur.x + dx[i];
				int my = cur.y + dy[i];
				if(!check(mx,my))
					continue;
				if(distance[mx][my] > distance[cur.x][cur.y] + map[mx][my]) {
					distance[mx][my] = distance[cur.x][cur.y] + map[mx][my];
					que.offer(new Point(mx,my,distance[mx][my]));
				}
			}
			
		}
		return distance[cmd-1][cmd-1];
	}
	private static boolean check(int mx, int my) {
		return mx>=0 && mx < cmd && my >= 0 && my < cmd;
	}
}