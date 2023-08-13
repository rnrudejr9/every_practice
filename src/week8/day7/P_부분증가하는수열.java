package week8.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_부분증가하는수열 {
    static int[] arr;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        powerSet(0);
    }

    public static void powerSet(int cnt){
        if(cnt == n){
            for(int i = 0;i<n;i++){
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        visited[cnt] = true;
        powerSet(cnt+1);
        visited[cnt] = false;
        powerSet(cnt+1);
    }
}
