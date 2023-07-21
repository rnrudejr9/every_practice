package week5.day5;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 처음 접근법
 * 계단식으로 내려가는 BFS - 조건식을 수정함
 * DP 방식 접근, 기저조건을 두고 아래에서 부터 찾아 올라가는 방식
 *
 */

public class P_정수삼각형2 {

    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N-1][i] = arr[N-1][i];
        }
        System.out.println(find(0,0));

    }

    static int find(int depth, int idx) {
        //기저조건
        if(depth == N - 1) return dp[depth][idx];

        if(dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}