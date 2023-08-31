import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * MST를 형성한 후 사용했던 정점을 대상으로 가중치를 더한다
 * que 에는 방문했던 정점과 가중치가 오름차순으로 쌓인
 * @author SSAFY
 *
 */
public class Main {
	static int n;
	static int m;
	static ArrayList<ArrayList<Edge>> map;
	static int ans;

	static class Edge implements Comparable<Edge> {
		int v;
		int weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}
			map = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				map.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				map.get(x).add(new Edge(y, w));
				map.get(y).add(new Edge(x, w));
			}

			boolean[] visited = new boolean[n];
			PriorityQueue<Edge> que = new PriorityQueue<>();
			PriorityQueue<Edge> reque = new PriorityQueue<>(Collections.reverseOrder());
			int t = n - 1;
			que.offer(new Edge(0, 0));

			while (!que.isEmpty()) {
				Edge cur = que.poll();
				if (visited[cur.v]) {
					ans += cur.weight;
					continue;
				}
				visited[cur.v] = true;
				if (t >= 0) {
					//				ans -= cur.weight;
					t--;
				} else
					break;
				for (Edge next : map.get(cur.v)) {
					if (visited[next.v])
						continue;

					que.offer(next);
				}
				//			ans += Math.abs(max - min);
			}
			//
			//		Arrays.fill(visited, false);
			//		reque.offer(new Edge(0, 0));
			//		t = n - 1;
			//		while (!reque.isEmpty()) {
			//			Edge cur = reque.poll();
			//			if (visited[cur.v]) {
			//				continue;
			//			}
			//			visited[cur.v] = true;
			//			if (t >= 0) {
			//				ans += cur.weight;
			//				t--;
			//			} else
			//				break;
			//			for (Edge next : map.get(cur.v)) {
			//				if (visited[next.v])
			//					continue;
			//				reque.offer(next);
			//			}
			//			//			ans += Math.abs(max - min);
			//		}

			System.out.println(ans);

		}
	}
}