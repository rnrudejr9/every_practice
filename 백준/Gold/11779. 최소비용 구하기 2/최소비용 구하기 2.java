import java.util.*;
import java.io.*;

/**
 * 어떻게하면 방문기록들을 남길까?
 * 
 * @author SSAFY
 *
 */
public class Main {
	static int n;
	static int m;
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
	static int[] parent;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new ArrayList<>();
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map.get(start).add(new Edge(end, w));
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;
		
		System.out.println(dijkstra(s, e));
		
		
		Stack stack = findStart(e, s,new Stack<Integer>());	
		System.out.println(stack.size());
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
		
		
		
	}
	public static void init() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	public static int dijkstra(int start, int end) {
		distance = new int[n];
		visited = new boolean[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;	
		init();
		
		PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2)->Integer.compare(e1.w,e2.w));
		que.offer(new Edge(start,0));
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(visited[cur.v])
				continue;
			visited[cur.v] = true;
			if(visited[end]) {
				return distance[end];
			}
			
			for(Edge next : map.get(cur.v)) {
				if(visited[next.v])
					continue;
				if(distance[next.v] > distance[cur.v]+next.w) {
					distance[next.v] = distance[cur.v]+next.w;
					que.offer(new Edge(next.v,distance[next.v]));
					parent[next.v] = cur.v;
				}
			}
		}
		return -1;
	}
	

	
	public static Stack<Integer> findStart(int x, int start,Stack<Integer> st) {
		st.push(x+1);
		if(parent[x] == x) {
			return st;
		}else {
			return findStart(parent[x], start,st);
		}
	}
}