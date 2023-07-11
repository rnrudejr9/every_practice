package week4.day2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class swea_숫자배열회전 {
    static StringBuilder[] line;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            line = new StringBuilder[N];

            for(int i =0;i<N;i++)
                for(int j=0;j<N;j++)
                    arr[i][j] = sc.nextInt();



            int[][] arr90 = changeArr(arr, N);
            int[][] arr180 = changeArr(arr90, N);
            int[][] arr270 = changeArr(arr180, N);


        }
    }


    public static void print(int[][] arr){
        for(int i = 0; i < arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] changeArr(int[][] arr, int N){
        int[][] target = new int[N][N];
        for(int i =0;i<N;i++)
            for(int j=0;j<N;j++)
                target[i][j] = arr[N-j-1][i];
        return target;
    }

}
