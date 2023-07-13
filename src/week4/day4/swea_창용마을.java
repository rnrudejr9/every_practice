package week4.day4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


/**
 * 자바 유니온 파인드 알고리즘
 *
 */
public class swea_창용마을 {
    static int[] parent;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/7465.txt"));

	   Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            parent = new int[n+1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            // 1,2,3,4,5,6
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                union(x, y);
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < parent.length; i++) {
                set.add(find(parent[i]));
            }
            System.out.println("#" + test_case + " " + set.size());
        }
    }

    public static int find(int x){
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    public static void print(){
        System.out.println(Arrays.toString(parent));
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if( a > b ){
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }
    public static boolean isSameParent(int x,int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return  true;
        }else{
            return false;
        }
    }
}
