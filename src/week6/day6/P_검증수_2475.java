package week6.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_검증수_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(st.nextToken()) ;
            int b = a*a;
            sum+= b;
        }
        System.out.println(sum%10);


    }

}
