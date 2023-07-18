package week5.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_n과m8 {

    static int n;
    static int m;
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        int[] arr = new int[n];
        output = new int[m];
        temp = br.readLine().split(" ");
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arr);

        print(0,0,arr);
    }
    public static void print(int depth, int index,int[] arr) {
        if( depth == m ) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        if(index >= n) {
            return;
        }

        for(int i =index;i<arr.length;i++) {
            output[depth] = arr[i];
            print(depth+1,i,arr);
        }
    }
}