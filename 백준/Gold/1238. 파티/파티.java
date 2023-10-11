import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
    


/**
 * 모든 좌표에서 X 까지의 거리를 이차원배열에 저장
 * 2차원배열에는 [start좌표][end좌표]의 거리값이 존재함
 * 
 * @author SSAFY
 *
 */
public class Main {
	static int n;
	static int m;
	static int x;
	static ArrayList<ArrayList<Edge>> list;
	static PriorityQueue<Edge> que;
	static boolean[] visited;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;
	static int[][] ans;

	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		ans = new int[n][n];

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list.get(start).add(new Edge(end, value));
		}
		
		for (int i = 1; i <= n; i++) {
			dijstra(i);
		}
		
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			
			maxValue = Math.max(maxValue, ans[x-1][i] + ans[i][x-1]);
		}
		System.out.println(maxValue);
		
	}

	public static void dijstra(int start) {
		visited = new boolean[n+1];
		distance = new int[n+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		que = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.w, e2.w));
		
		que.offer(new Edge(start, 0));
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(visited[cur.v])
				continue;
			visited[cur.v] = true; 
			for(Edge next : list.get(cur.v)) {
				if(visited[next.v])
					continue;
				if(distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					que.offer(new Edge(next.v, distance[next.v]));
				}
			}
		}
		for (int i = 0; i < distance.length-1; i++) {
			ans[start-1][i] = distance[i+1];
		}
}}