package week4.day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 새로배운점
 * 값유무 검사시 set 사용!
 *
 * 접근
 * 가로세로는 그냥 구하고, 영역별로 체크
 */
public class swea_스토구검증 {
    static final int size = 9;
    static int[][] map = new int[size][size];
    static boolean isTrue = true;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            isTrue = true;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    set.add(map[i][j]);
                }
                if(set.size() != 9){
                    isTrue = false;
                }
            }

            for (int i = 0; i < size; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    set.add(map[j][i]);
                }
                if(set.size() != 9){
                    isTrue = false;
                }
            }
            for (int i = 0; i < size; i+=3) {
                for (int j = 0; j < size; j+=3) {
                    boolean config = config(i, j);
                    if(!config){
                        isTrue = false;
                    }
                }
            }

            if(isTrue){
                System.out.printf("#%d %d\n",test_case,1);
            }else{
                System.out.printf("#%d %d\n",test_case,0);
            }
        }
    }

    public static boolean config(int x,int y){
        HashSet<Integer> set = new HashSet<>();
        for(int i = x;i<=x + 2;i++){
            for (int j = y; j <= y + 2; j++) {
                set.add(map[i][j]);
            }
        }
        if(set.size() != 9){
            return false;
        }

        return true;
    }
}
