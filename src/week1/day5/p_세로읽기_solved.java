package week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class p_세로읽기_solved {
    static int n;

    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 5;
        arr = new String[5];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if(maxLen < arr[i].length()){
                maxLen = arr[i].length();
            }
        }

        for(int i=0;i<maxLen;i++){
            print(i,arr);
        }
    }
    public static void print(int index,String[] arr){
        for(int i =0;i<n;i++){
            try {
                System.out.print(arr[i].charAt(index));
            }catch (Exception e){

            }
        }
    }
}
