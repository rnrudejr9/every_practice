package week5.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_n과m4 {

    static int[] output;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        arr= new int[n];
        for(int i = 0 ; i < n ;i++) {
            arr[i] = i+1;
        }
        output = new int[m];
        comb(0,0,n,m);
    }
    public static void comb(int depth, int index, int n,int m) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        if(index >= n) {
            return;
        }
//		output[depth] = arr[index];
        for (int i = index; i < arr.length; i++) {
            output[depth] = arr[i];
            comb(depth+1,i,n,m);
        }
    }

}