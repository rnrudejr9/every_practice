package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class swea_최빈수구하기 {


    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < 1000; i++) {
                int temp = sc.nextInt();
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }else{
                    map.put(temp,1);
                }

                map.computeIfPresent(temp, (Integer key,Integer value) -> value + 1);
            }

            List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());

//            value 값이 같을때 key 값 비교
//            value 가 같은 key 값만 추출해서 sort 한다.
            List<Map.Entry<Integer, Integer>> list = entries.stream().filter(e -> e.getValue() == entries.get(0).getValue()).sorted().collect(Collectors.toList());
            Integer key = list.get(list.size() - 1).getKey();
            System.out.println("#" + test_case + " " + key);

        }

    }


}
