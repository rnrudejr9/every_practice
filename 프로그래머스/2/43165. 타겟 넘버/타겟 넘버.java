import java.util.*;
import java.io.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer> map;
    static int size;
    static int[] number;
    static int t;
    static int ans;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        size = numbers.length;
        number = new int[size];
        number = numbers.clone();
        t = target;
        ans = 0;
        calc(0,size,0);
        return ans;
    }
    public static void calc(int depth, int cnt, int value){
        if(depth == cnt) {
            if(value == t){
                ans++;
            }
            return;
        }
        calc(depth+1,cnt,value+number[depth]);
        calc(depth+1,cnt,value-number[depth]);
    }
}