
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cost;
    static int[][] dp;
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n+1][3];
        dp = new int[n+1][3];

        for(int i =1;i<=n;i++){
            String[] str = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(str[0]);
            cost[i][1] = Integer.parseInt(str[1]);
            cost[i][2] = Integer.parseInt(str[2]);
        }

        int result = Math.min(calc(n,R),Math.min(calc(n,G),calc(n,B)));
        System.out.println(result);
    }

    public static int calc(int n,int color){
        if(n == 1){
            if(color == R){
                return cost[1][R];
            }
            if(color == G){
                return cost[1][G];
            }
            if(color == B){
                return cost[1][B];
            }
        }
        if(dp[n][color] == 0 ){
            if(color == R){
                dp[n][R] = Math.min(calc(n-1,G),calc(n-1,B))+cost[n][R];
            }
            if(color == G){
                dp[n][G] = Math.min(calc(n-1,R),calc(n-1,B)) + cost[n][G];
            }
            if(color == B){
                dp[n][B] = Math.min(calc(n-1,R),calc(n-1,G)) + cost[n][B];
            }
        }
        return dp[n][color];
    }
}
