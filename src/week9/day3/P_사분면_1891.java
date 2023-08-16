package week9.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 첫시도 런타임(numberFormatException) x,y가 2의 50승 확인
 * 1: 롱타입으로 변경
 * 경우의 수 따졌을때 2의 50승을 해결하기엔 역부족
 * 그래도 한번 재귀를 탈때 50번을 타는 거니까, 50 * 4 정도? 괜찮지 않을까?
 *
 * @author SSAFY
 *
 */
public class P_사분면_1891 {
	static long[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, n);
		map = new long[size][size];
		
		st= new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		
		recur(0,0,size,"");

		int tempX = 0;
		int tempY = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
//				System.out.print(map[i][j] + " ");
				if(map[i][j] == num) {
//					System.out.println(i + " " + j);
					tempX = i;
					tempY = j;
				}
			}
		}
		x = tempX + x;
		y = tempY + y;


	}
	public static void recur(int x,int y, int size,String str) {
		if(size == 1) {
			map[x][y] = Long.valueOf(str);
			return;
		}
		
		
		int half = size / 2;
		
		int mx = x + half;
		int my = y + half;


		recur(x,y,half,str+"2");
		recur(x,y+half,half,str+"1");
		recur(x+half,y,half,str+"3");
		recur(x+half,y+half,half,str+"4");
	}
}
