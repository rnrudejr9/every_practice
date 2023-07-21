package week5.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_포켓몬마스터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            //n개 줄 포켓몬번호 1~n
            map.put(Integer.toString(i+1), line);
            map2.put(line, Integer.toString(i+1));
            //m개 숫자 -> 포 -> 숫
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if(map.containsKey(s)){
                System.out.println(map.get(s));
            }else if(map2.containsKey(s)) {
                System.out.println(map2.get(s));
            }
        }
        
        
    }
}
