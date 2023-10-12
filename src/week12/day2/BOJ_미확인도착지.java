package week12.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * s 지점에서 출발
 * 목적지 후보중 하나가 그들의 목적지 - 최단거리조회
 * g와 h 교차로 사이에 있는 도로 지남
 *
 * 다익스트라를 그린 후에 도착 목적지에서 부모를 찾아가면서 g,h 사이 도로를 건너는지 확인
 * 양방향 그래프일때 랭크 나누는법?
 * +1 -1 해주는거 너무 어려움 귀찮음 스타일 차이인지?
 * 16% : 해당 문제풀이는 경로가 다르고 가중치가 같은 그래프에서는 정답을 찾을 수 없ㅇ므
 */
public class BOJ_미확인도착지 {
	static int n; //교차로
	static int m; // 도로
	static int t; //목적지 후보 수
	static int s; // 출발지
	static int g; // g,h 교차로 사이에 있는 도로
	static int h;
	static int[] sub;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> map;
	static int[] parent;
	static HashSet<Integer> set;
	static PriorityQueue<Integer> ans = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			init(br);
			distance = new int[n];
			distance[s] = 0;
			visited = new boolean[n];
			Arrays.fill(distance,Integer.MAX_VALUE);
			parent = new int[n];
			for (int j = 0; j < n; j++) {
				parent[j] = j;
			}
			dijkstra(s,h);
			dijkstra(h,g);

			for (int j = 0; j < t; j++) {
				if(dijkstra(g,sub[j])) {
					ans.offer(sub[j] + 1);
				}
			}
			while(!ans.isEmpty()){
				System.out.print(ans.poll() + " ");
			}
			System.out.println();

		}
	}
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static int find(int x){
		set.add(x);
		if(x == parent[x]){
			return x;
		}else{
			return find(parent[x]);
		}
	}
	public static boolean dijkstra(int start,int end){

		PriorityQueue<Edge> que = new PriorityQueue<Edge>((e1,e2) -> Integer.compare(e1.w,e2.w));
		que.offer(new Edge(start,0));

		while(!que.isEmpty()){
			Edge cur = que.poll();
			if(visited[cur.v])
				continue;
			visited[cur.v] = true;
			if(end != 2001 && visited[end]){
				return true;
			}
			for(Edge next : map.get(cur.v)){
				if(visited[next.v])
					continue;
				if(distance[next.v] > distance[cur.v] + next.w){
					distance[next.v] = distance[cur.v] + next.w;
					que.offer(new Edge(next.v,distance[next.v]));
					parent[next.v] = cur.v;
				}
			}
		}
		return false;
	}


	public static void init(BufferedReader br) throws IOException {
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()) - 1;
		g = Integer.parseInt(st.nextToken()) - 1;
		h = Integer.parseInt(st.nextToken()) - 1;
		map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			map.get(a).add(new Edge(b,d));
			map.get(b).add(new Edge(a,d));
		}
		sub = new int[t];
		for (int j = 0; j < t; j++) {
			st = new StringTokenizer(br.readLine());
			sub[j] = (Integer.parseInt(st.nextToken()) - 1);
		}
	}
}
