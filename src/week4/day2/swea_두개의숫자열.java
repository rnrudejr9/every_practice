package week4.day2;

import java.util.Arrays;
import java.util.Scanner;

public class swea_두개의숫자열 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            str = sc.nextLine().split(" ");
            int[] brr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

            int max = 0;
            if(arr.length > brr.length){
                int start = 0;
                int end = brr.length - 1;
                int size = brr.length;

                for(int i = start;i<=arr.length - size; i++){
                    int[] copy = Arrays.copyOfRange(arr, i, size + i);
                    max = calc(copy,brr,size) > max ? calc(copy,brr,size) : max;
                }
            }else{
                int start = 0;
                int end = arr.length - 1;
                int size = arr.length;

                for(int i = start;i<=brr.length - size; i++){
                    int[] copy = Arrays.copyOfRange(brr, i, size + i);
                    max = calc(copy,arr,size) > max ? calc(copy,arr,size) : max;
                }
            }

            System.out.println("#" + test_case + " " + max);

        }
    }
    public static int calc(int[] arr, int[] brr,int size){
        int result = 0;
        for(int i =0;i<size ;i++){
            result += arr[i] * brr[i];
        }
        return result;
    }
}
