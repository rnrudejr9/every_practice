package week4.day1;//////////

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class swea_최빈수구하기
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int number = sc.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < 1000; i++) {
                int temp = sc.nextInt();
                map.put(temp,map.getOrDefault(temp,0)+1);
//	                map.computeIfPresent(temp, (Integer key,Integer value) -> value + 1);
            }

            /**
             * value 로 map 오름차순 정리
             */
            List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());

//	            entries.stream().forEach((e)->System.out.println(e.getKey() + " " + e.getValue()));;


            /**
             * value 값이 같을때 key 값 비교
             * value 가 같은 key 값만 추출해서 sort 한다
             */
            int maxSize = entries.get(entries.size()-1).getValue();

            List<Map.Entry<Integer, Integer>> list = entries.stream()
                    .filter(e->e.getValue() == maxSize)
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toList());

            Integer key = list.get(list.size() - 1).getKey();
            System.out.println("#" + test_case + " " + key);

        }
    }
}