package week5.day6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_숨바꼭질_1697 {
    static int[] arr;
    static int k;
    static int[] dx = {1, -1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100_001];
        find(n);
    }
    static class Data{
        public int x;
        public int value;

        public Data(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }
    public static void find(int x){
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(x,1));
        while(!queue.isEmpty()){
            Data data = queue.poll();
            int px = data.x;
            if(arr[px] == k){
                System.out.println("fin " + data.value);
            }
            if(arr[px] != 0){
                continue;
            }
            arr[px] = data.value;
            int x1 = px + 1;
            int x2 = px - 1;
            int x3 = px * 2;
            if(x1 >= 0 && x1 < arr.length) {
                queue.add(new Data(x1, data.value + 1));
            }
            if(x2 >= 0 && x2 < arr.length) {
                queue.add(new Data(x2, data.value + 1));
            }
            if(x3 >= 0 && x3 < arr.length) {
                queue.add(new Data(x3, data.value + 1));
            }
        }
    }
}
