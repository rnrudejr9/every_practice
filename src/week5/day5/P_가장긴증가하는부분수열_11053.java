package week5.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        int[] dp = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        dp[0] = 1;


        System.out.println(dp[dp.length-1]);
    }
}
