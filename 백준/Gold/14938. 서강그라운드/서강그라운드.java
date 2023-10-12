import java.util.*;
import java.io.*;
/**
 * 9퍼센트 틀림
 * 다익스트라 사용 -> distance배열 -> 각 정점까지 최소거리
 * 1. 최소거리 <= 범위 
 * @author SSAFY
 *
 */
public class Main {
	static int n,m,r;
	static int[] item;
	static ArrayList<ArrayList<Edge>> map;
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int[] distance;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n];
		map = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			map.add(new ArrayList<>());
		}
		
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map.get(s).add(new Edge(e, w));
			map.get(e).add(new Edge(s, w));
		}
		
		int maxAns = 0;
		for (int i = 0; i < n; i++) {
			maxAns = Math.max(dijkstra(i), maxAns);
		}
		System.out.println(maxAns);
		
	}
	public static int dijkstra(int start) {
		distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[n];
		distance[start] = 0;
		PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.w, e2.w));
		que.offer(new Edge(start,0));
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(visited[cur.v])
				continue;
			visited[cur.v]= true; 
			for(Edge next : map.get(cur.v)) {
				if(visited[next.v])
					continue;
				if(distance[next.v]>distance[cur.v]+next.w) {
					distance[next.v]=distance[cur.v] + next.w;
					que.offer(new Edge(next.v,distance[next.v]));
				}
			}
		}
		
		return itemCount();
	}
	public static int itemCount() {
		int ans = 0;
		for (int i = 0; i < distance.length; i++) {
			if(distance[i] <= m) {
				ans += item[i];
			}
		}
		return ans;
	}
}