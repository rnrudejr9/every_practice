import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, d, c;
	static ArrayList<ArrayList<Edge>> map;
	static int[] distance;
	static boolean[] visited;

	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken()) -1;
			map = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				map.add(new ArrayList<>());
			}
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) -1;
				int b = Integer.parseInt(st.nextToken()) -1;
				int s = Integer.parseInt(st.nextToken());
				map.get(b).add(new Edge(a, s));
			}
			dijkstra(c);
		}
	}

	public static void dijkstra(int start) {
		distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[n];
		distance[start] = 0;

		PriorityQueue<Edge> que = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.w, e2.w));
		que.offer(new Edge(start, 0));
		while (!que.isEmpty()) {
			Edge cur = que.poll();
			if (visited[cur.v])
				continue;
			visited[cur.v] = true;
			for (Edge next : map.get(cur.v)) {
				if (visited[next.v])
					continue;
				if (distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					que.offer(new Edge(next.v,distance[next.v]));
				}
			}
		}
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < distance.length; i++) {
			if(max < distance[i] && distance[i] != Integer.MAX_VALUE) {
				max = distance[i];
			}
			if(visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt + " " + max);

	}
}