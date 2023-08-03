package week7.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_도영이가만든맛있는음식_2961 {
    static boolean[] visited;
    static int n;
    static SB[] m;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        m = new SB[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            m[i] = new SB(s, b);
        }
        powerSet(0);
        System.out.println(result);
    }

    public static int calc(){
        int s = 1;
        int b = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]){
                s *= m[i].s;
                b += m[i].b;
            }else{
                count += 1;
            }
        }
        if(count == n){
            return Integer.MAX_VALUE;
        }
        return Math.abs(s-b);
    }

    public static void powerSet(int cnt) {
        if (cnt == n) {
            result = Math.min(calc(),result);
            return;
        }
        visited[cnt] = true;
        powerSet(cnt + 1);
        visited[cnt] = false;
        powerSet(cnt + 1);

    }

    static class SB {
        int s;
        int b;

        public SB(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}
