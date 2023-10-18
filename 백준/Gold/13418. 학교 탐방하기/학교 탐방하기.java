/**
 * 오르막길을 k번 오를때 피로도는 k제곱이 됨
 * 내리막길 갔다가 오르막길 갈때는 고려하지 않는다 
 * 
 * 0은 오르막길 1은 내리막길
 * 오르막길 갯수 계산해서 풀면 되겠다.
 * 
 * 1차 틀림 : 절댓값 적용안함
 * 2차틀림 81퍼센트 : 분리메소드 리펙토링, visited[0] 방문처리, 타입 long으로 변경
 * 3차 : 
 * @author SSAFY
 *
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static class Edge{
		int e;
		int w;
		public Edge( int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [e=" + e + ", w=" + w + "]";
		}
		
	}
	static PriorityQueue<Edge> que;
	static PriorityQueue<Edge> m_que;
	static ArrayList<ArrayList<Edge>> map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		que = new PriorityQueue<>((e1,e2)->Integer.compare(e1.w, e2.w));
		m_que = new PriorityQueue<>((e1,e2)->e2.w-e1.w);
		
		map = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			map.add(new ArrayList<>());
		}
		st= new StringTokenizer(br.readLine());
		
		int f_a = Integer.parseInt(st.nextToken());
		int f_b = Integer.parseInt(st.nextToken());
		int f_w = Integer.parseInt(st.nextToken());
		Edge f_edge = new Edge(f_b,f_w);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map.get(a).add(new Edge(b,w));
			map.get(b).add(new Edge(a,w));
		}
		
		long big = s_prim(que,f_edge);
		long small = s_prim(m_que,f_edge);
		big = (long)Math.pow(big, 2);
		small = (long)Math.pow(small, 2);
		System.out.println(big - small);
	}
	
	public static long s_prim(PriorityQueue<Edge> s_que,Edge f_edge) {
		long cnt = 0;
		s_que.offer(f_edge);
		visited= new boolean[n+1];
		visited[0] = true;
		
		while(!s_que.isEmpty()) {
			Edge cur = s_que.poll();
			if(visited[cur.e])
				continue;
			if(cur.w == 0) {
				cnt++;
			}
			visited[cur.e]= true; 
			for(Edge next : map.get(cur.e)) {
				if(visited[next.e]) {
					continue;
				} 
				
				s_que.offer(new Edge(next.e,next.w));
			}
		}
		return cnt;
	}
	
	
}