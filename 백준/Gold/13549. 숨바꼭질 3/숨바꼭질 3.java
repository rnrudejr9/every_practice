import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dp = new int[100_001];
	static boolean[] visited = new boolean[100_001];
	static PriorityQueue<int[]> que = new PriorityQueue<>((e1,e2) -> Integer.compare(e1[1],e2[1]));
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		play(n);
	}
	public static void play(int start) {
		que.offer(new int[] {start,0});
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int target = temp[0];
			int right = temp[0] + 1;
			int left = temp[0] - 1;
			int two = temp[0] * 2;
			int value = temp[1];
			if(visited[target]) {
				continue;
			}
			
			
			visited[target] = true;
			
		
			if(dp[target] != -1 ) {
				dp[target] = Math.min(dp[target], value);
				if(target == k) {
					System.out.println(dp[target]);
					break;
				}
			}
			
			if(check(right)) {
				que.offer(new int[] {right, value+1});
			}
			if(check(left)) {
				que.offer(new int[] {left, value+1});
			}
			if(check(two)) {
				que.offer(new int[] {two, value});
			}
			
		}
	}
	private static boolean check(int val) {
		// TODO Auto-generated method stub
		return 0<= val && val < dp.length;
	}
	
	
}