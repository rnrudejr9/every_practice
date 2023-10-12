import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 마지막 체크하는 로직 어떻게? - 나는 flag로 했음
 * 다익스트라 사용해서 최단거리 distance 구함
 * @author SSAFY
 *
 */
public class Main {
	static int n;
	static int m;
	static int k;
	static int x;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> map;
	static final int INF = Integer.MAX_VALUE / 1000;
	static PriorityQueue<Edge> que;

	static class Edge implements Comparable<Edge> {
		int v;
		int w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(w, o.w);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			map.get(start).add(new Edge(end, 1));
		}

		dijkstra(x - 1);
	}

	public static void dijkstra(int start) {
		visited = new boolean[n];
		distance = new int[n];
		Arrays.fill(distance, INF);
		que = new PriorityQueue<>();

		distance[start] = 0;
		que.offer(new Edge(start, 0));

		while (!que.isEmpty()) {
			Edge cur = que.poll();
			if (visited[cur.v])
				continue;
			visited[cur.v] = true;
			for (Edge next : map.get(cur.v)) {
				if (distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					que.offer(new Edge(next.v, distance[next.v]));
				}
			}
		}
		int flag = 0;
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == k) {
				System.out.println(i + 1);
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println(-1);
		}
	}
}