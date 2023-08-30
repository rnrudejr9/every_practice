

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(true) {
			if(n%5 ==0) {
				cnt += n/5;
				n=0;
				break;
			}else {
				if(n<3) {
					break;
				}
				n = n-3;
				cnt++;
			}
		}
		
		if(n==0) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	
	}

}
