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

    static int[] nNumber;
    static int[] comb;
    static boolean[] visited;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        HashSet<Integer> data = new HashSet<>();
        StringTokenizer st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        int[] newData = new int[10-m];
        int size = 0;
        for(int i =0;i<=9;i++){
            if(!data.contains(i)){
                newData[size++] = i;
            }
        }

        System.out.println(Arrays.toString(newData));

        nNumber = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        comb = new int[nNumber.length];
        visited = new boolean[newData.length];

        perm(newData,comb,visited,0, newData.length, nNumber.length);

    }



    public static void perm(int[] arr,int[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            System.out.println(Arrays.toString(output));
            return;
        }
        for(int i =0;i<n;i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i] = false;
            }
        }
    }


}
