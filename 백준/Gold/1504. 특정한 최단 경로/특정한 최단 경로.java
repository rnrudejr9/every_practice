import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * start - v1 - v2 - end
 * start - v2 - v1 - end
 * 75% 틀렸습니다 : 출력 -1 오류
 * 75% : INF = Integer.MAXVALUE
 * @author SSAFY
 * INF 적정값 : https://www.acmicpc.net/board/view/85172
 *
 */
public class Main {	
	static int V,E;
	static int v1;
	static int v2;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> map;
	static PriorityQueue<Edge> que;
	static final int INF = 500_000_000;
	static class Edge{
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map.get(start-1).add(new Edge(end-1, weight));
			map.get(end-1).add(new Edge(start-1,weight));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()) -1;
		v2 = Integer.parseInt(st.nextToken()) -1;
		
		
		int ans = 0;
		ans += dijstra(0, v1);
		ans += dijstra(v1, v2);
		ans += dijstra(v2, V-1);
		int ans2 = 0;
		ans2 += dijstra(0, v2);
		ans2 += dijstra(v2, v1);
		ans2 += dijstra(v1, V-1);
		
		int result = Math.min(ans, ans2);
		if(result >= INF) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
	}
	public static int dijstra(int start, int end) {
		visited = new boolean[V];
		distance = new int[V];
		que = new PriorityQueue<>((e1,e2)->Integer.compare(e1.w, e2.w));
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		que.offer(new Edge(start, 0));
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(visited[cur.v]) {
				continue;
			}
			visited[cur.v] = true;
			if(visited[end]) {
				return distance[end];
			}
			for(Edge next : map.get(cur.v)) {
				if(visited[next.v])
					continue;
				if(distance[next.v] > distance[cur.v]+ next.w) {
					distance[next.v] = distance[cur.v]+ next.w;
					que.offer(new Edge(next.v,distance[next.v]));
					
				}
			}
		}
		return INF;
		
	}
}