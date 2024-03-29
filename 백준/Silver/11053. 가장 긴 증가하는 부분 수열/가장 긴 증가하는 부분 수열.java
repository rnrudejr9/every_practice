import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] dp;
	static int target = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 1;
		
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
			}
		}
		int max = 0;
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
}