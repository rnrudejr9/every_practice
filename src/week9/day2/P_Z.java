package week9.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * 분할정복으로 해결하기
 *
 * n은 15까지 주어진다.
 * 2^15는  32,768 * 32,768 = 10억의 계산량
 * 시간초과 발생 - 버퍼리더 수정해도 안됨
 *
 *
 *
 *
 * @author SSAFY
 *
 */
public class P_Z {
    static int count=0;
    static int targetX;
    static int targetY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);


        recur(0,0,size);


    }

    public static void recur(int x,int y,int size) {
        if(size == 2) {
            for(int i = x;i<x+size;i++) {
                for (int j = y; j < y+size; j++) {
                    if(i == targetX && j == targetY) {
                        System.out.println(count);
                    }
                    count++;
                }
            }
            return;
        }
        int half = size / 2;
        int mx = x + half;
        int my = y + half;

        if(mx > targetX && my > targetY) {
            recur(x,y,half);
        }else if( mx > targetX && (my <= targetY && my >= 0)) {
            count+=half * half;
            recur(x,y+half,half);
        }else if((mx <= targetX && mx >=0) && my > targetY ) {
            count += half * half * 2;
            recur(x+half,y,half);
        }else if(mx <= targetX && my <= targetY){
            count += half * half * 3;
            recur(x+half,y+half,half);
        }
//		(mx <= targetX && my <= targetY)





    }



}
