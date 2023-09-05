import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int T=10007;
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int[] p=new int[N+2];
		p[1]=1;
		p[2]=3;
		for (int i = 3; i <N+1; i++) {
			if(i>2 && i%2==0 ){
				p[i]=((((p[i/2])*(p[i/2])))%T
						+(((2*(p[i/2-1]))*(p[i/2-1])))%T)%T;
			}else if(i>2 && i%2==1) {
				p[i]=(((p[i-1])+(2*(p[i-2]))))%T;
			}
		}
		System.out.println(p[N]);
	}
	
}