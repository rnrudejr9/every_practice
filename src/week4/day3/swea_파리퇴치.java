package week4.day3;

import java.util.Scanner;

public class swea_파리퇴치 {
    static int n;
    static int m;
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }


        }
    }
}
