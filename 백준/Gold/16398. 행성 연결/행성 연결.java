import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 50% 틀렸습니다.
 * 간 만 프 생각남 - 프림 알고리즘 수정
 * 62% 틀렸습니다. 
 * 원소값 1억 인거 보고 Long 타입 수정
 * 
 * @author SSAFY
 *
 */
public class Main {

	static int n;
	static PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2)-> Long.compare(e1.w, e2.w));
	static class Edge{
		int s;
		int e;
		long w;
		public Edge(int s, int e, long w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
	}
	
	static PriorityQueue<Edge> primeQue = new PriorityQueue<>((e1,e2)->Long.compare(e1.w,e2.w));
	static int[] parent;
	static ArrayList<ArrayList<Edge>> map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		parent = new int[n];
		visited = new boolean[n];
		map =new ArrayList<>();
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if( i == j ) {
					st.nextToken();
					continue;
				}
				int w = Integer.parseInt(st.nextToken());
				que.offer(new Edge(i,j,w));
				map.get(i).add(new Edge(i,j,w));
			}
		}
		
		
//		int wage = kruskal();
		long wage = prim();
		
		
		System.out.println(wage);
	}
	private static long prim() {
		long wage = 0;
		primeQue.offer(new Edge(0,0,0));
		while(!primeQue.isEmpty()) {
			Edge cur = primeQue.poll();
			if(visited[cur.e]) {
				continue;
			}
			wage += cur.w;
			visited[cur.e] = true;
			for(Edge next : map.get(cur.e)) {
				if(visited[next.e]){
					continue;
				}
				primeQue.offer(new Edge(next.s,next.e,next.w));
			}
		}
		return wage;
	}
	private static int kruskal() {
		int wage = 0;
		int v = 0;
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(union(cur.s,cur.e)) {
				wage += cur.w;
				v += 1;
			}
		}
		return wage;
	}
	public static boolean union(int a,int b) {
		a = find(a);
		b = find(b);
		if( a == b) {
			return false;
		}else {
			parent[b] = a;
		}
		return true;
	}
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	

}