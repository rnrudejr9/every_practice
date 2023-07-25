package week6.day2;

import java.util.Scanner;

/**
 * 1차시도 : 재귀함수, for문으로 풀다가 디버깅 후 오버플로 발생 확인
 * 규칙성 발견, 자리수 별로 뒤에 0의 자리가 다름 확인
 * @author SSAFY
 *
 */
public class P_1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n == 0) {
			System.out.println(1);
		}
		int div = n / 10;
		int rest = n % 10;
		 
		int mul = div * 2;
		if(!(rest >= 0 && rest < 5)) {
			mul += 1;
		}	
		System.out.println(mul);
			
	}
	
	
}
