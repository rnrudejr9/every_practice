package week4.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_최빈수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input1204.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<Integer, Integer> map;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            map = new HashMap<>();
            br.readLine();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Comparator<Map.Entry<Integer, Integer>> valueComparator = Map.Entry.comparingByValue();
            Comparator<Map.Entry<Integer, Integer>> keyComparator = Map.Entry.comparingByKey();


            Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), valueComparator.thenComparing(keyComparator.reversed()));

            sb.append("#" + t + " " + maxEntry.getKey() + "\n");
        }

        System.out.println(sb);
    }
}