import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	static int n;
	static int m;
	static ArrayList<ArrayList<Point>> map;
	static class Point{
		int s;
		int e;
		int w;
		boolean univ;
		public Point(int s, int e, int w, boolean univ) {
			this.s = s;
			this.e = e;
			this.w = w;
			this.univ = univ;
		}
		@Override
		public String toString() {
			return "Point [s=" + s + ", e=" + e + ", w=" + w + ", univ=" + univ + "]";
		}
		
		
	}
	static int[] univers;
	
	static PriorityQueue<Point> que = new PriorityQueue<>((e1,e2)->Integer.compare(e1.w, e2.w));
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		univers = new int[n];
		parent = new int[n];
		init();
		st = new StringTokenizer(br.readLine());

		
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
			univers[i] = convertToInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			boolean connect = true;
			if(univers[s] == univers[e]) {
				connect = false;
			}
			que.offer(new Point(s,e,w,connect));
		}
		
		kruskal();
		
	}
	private static void kruskal() {
		int cnt = 0;
		int min = 0;
		
		while(!que.isEmpty()) {
			
			Point cur = que.poll();
			if( cur.univ && union(cur.s,cur.e)) {
				cnt++;
				min += cur.w;
			}
		}
		
		if( cnt != n-1) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	public static int convertToInt(String s) {
		if( s.equals("M")) {
			return 0;
		}else {
			return 1;
		}
	}
	public static void init() {
		for(int i = 0 ;i<n;i++) {
			parent[i] = i;
		}
	}
	public static int find(int x) {
		
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	public static boolean union(int a,int b) {
		a = find(a);
		b = find(b);
		if( a == b) {
			return false;
		}else {
			parent[a] = b;
		}
		return true;
	}
}