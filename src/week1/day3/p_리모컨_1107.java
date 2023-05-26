package week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class p_리모컨_1107 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] broken = new boolean[10];
        for(int i=0;i<m;i++){
            int n = Integer.parseInt(st.nextToken());
            broken[n] = true;
        }
        int result = Math.abs(n-100); //+,- 로 적용했을때
        int max = 999999;
        for(int i =0;i<max;i++){
            String str = String.valueOf(i);
            //해당 숫자를 string 전환
            int len = str.length();
            //숫자길이체크
            boolean isBroken = false;
            for(int j=0;j<len;j++){
                if(broken[str.charAt(j)-'0']){
                    isBroken = true;
                    break;
                    //만약 부서진 곳이 있으면 탈출
                }
            }
            if(!isBroken){
                int min = Math.abs(n - i) + len;
                result = Math.min(min,result);
            }
        }
        System.out.println(result);
    }


}
