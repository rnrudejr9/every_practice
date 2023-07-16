package week4.day6;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class p_NQUEEN_9663 {
    static int[][] map;
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int [] dy = {1,1,0,-1,-1,-1,0,1};
    static int n;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/9663.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int result = 0;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < dx.length; k++) {
                    DFS(i,j,k);
                }
                result += count(map);
                for (int k = 0; k < n; k++) {
                    Arrays.fill(map[k],0);
                }
            }
        }
        System.out.println(result);

    }

    public static int count(int[][] data){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(data[i][j] == 0){
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void DFS(int x,int y, int dir){
        map[x][y] = 1;
        int mx = x + dx[dir];
        int my = y + dy[dir];
        if(mx >= 0 && mx < n && my >= 0 && my < n){
            DFS(mx,my,dir);
        }else{
            return;
        }
    }
}
