package week5.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_n과m5 {
    static int n;
    static int m;
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        output = new int[m];
        int[] arr = new int[n];
        visited = new boolean[n];
        String[] temp2 = br.readLine().split(" ");
        for(int i =0;i<n;i++) {
            arr[i] = Integer.parseInt(temp2[i]);
        }
        Arrays.sort(arr);

        print(0,0,arr);
    }
    public static void print(int depth, int index,int[] arr) {
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            System.out.println(sb.toString());
            return;
        }
        if(index >= n) {
            return;
        }



        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] =true;
                output[depth] = arr[i];
                print(depth+1,i,arr);
                visited[i] = false;
            }
        }

    }
}