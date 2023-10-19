import java.util.*;


import java.io.*;


/**
 * 랜선의 길이 최대값은 가중치가 높은 상태의 MST
 * 캐릭터범위?
 * 
 * 잘못생각함
 * 최소의 값으로 MST 를 만들고 전체 간선의 가중치 합 - 최소의 값으로 ㄱ답을 구해야됨
 * (문제 잘읽기)
 * @author SSAFY
 *
 */
public class Main {
	static int n;
	static int[][] map;
	static PriorityQueue<Edge> que = new PriorityQueue<>((e1,e2)-> Integer.compare(e1.w, e2.w));
	static class Edge{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
	}
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				char c = str[j].charAt(0);
				int value = 0;
				if('a' <= c && 'z' >= c) {
					value = c - 'a' + 1;
				}else if('A' <= c && 'Z' >= c){
					value = c - 'A' + 27;
				}else if(c == '0') {
					continue;
				}
				sum += value;
				que.offer(new Edge(i,j,value));
			}
		}
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		int max = 0;
		int v = 0;
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(union(cur.s, cur.e)) {
				max += cur.w;
				v += 1;
			}
		}
		if( v == n-1 ) {
			System.out.println(sum - max);
		}else {
			System.out.println(-1);
		}
		
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