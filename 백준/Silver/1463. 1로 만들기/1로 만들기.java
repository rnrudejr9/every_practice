import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		System.out.println(calc(x,0));
		
	}
	
	static int calc(int x,int count) {
		if(x<2) {
			return count;
		}
		
		return Math.min(calc(x/2,count+1+(x%2)), calc(x/3,count+1+(x%3)));
	}

}
