package week1.day4;

import java.util.*;

public class p_주차요금계산_프로그래머스 {
    public static void main(String[] args) {
        int[] fee =new int[] {1, 10000, 3, 1000};
        String[] recode = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(fee,recode)));
    }
}

class Solution {
    static TreeMap<Integer,Integer> resultMap = new TreeMap<>();
    public int[] solution(int[] fees, String[] records) {
        int[] answer ={};
        HashMap<Integer,Integer> map = new HashMap<>();

        for(String s : records){
            String[] data = s.split(" ");
            Integer carNum = Integer.parseInt(data[1]);

            if(map.containsKey(carNum)){
                Integer getTime = map.get(carNum);
                Integer outTime = stringToTime(data[0]);
                int result = outTime - getTime;
                putResultData(carNum,result);
                map.remove(carNum);
            }else{
                map.put(carNum,stringToTime(data[0]));
            }
        }

        for(Integer carNum : map.keySet()){
            Integer getTime = map.get(carNum);
            Integer outTime = stringToTime("23:59");
            int result = outTime - getTime;
            putResultData(carNum,result);
        }



        int size = 0;
        answer = new int[resultMap.size()];
        for(Integer carNum : resultMap.keySet()){
            Integer time = resultMap.get(carNum);
            answer[size++] = pay(time,fees);
        }
        return answer;
    }
    public static void putResultData(int carNum,int money){
        if(resultMap.containsKey(carNum)){
            resultMap.put(carNum,money + resultMap.get(carNum));
        }else{
            resultMap.put(carNum,money);
        }
    }
    public static int stringToTime(String s){
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int result = (hour * 60) + min;
        return result;
    }

    public static int pay(int time,int[] fees){
        int money = 0;
        if(fees[0]<time){
            money = (int) Math.ceil((double)(time - fees[0])/fees[2]) * fees[3];
            money = money + fees[1];
        }else{
            money = fees[1];
        }
        return money;
    }

}