import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int n,k;
	static int[] data;
	static int[] print;
	static HashSet<Integer> set = new HashSet<>();
	static int count= 0;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		data = new int[n];
		visited = new boolean[n];
		print = new int[k];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
		System.out.println(set.size());

	}
	public static void comb(int depth,int index){
		if(depth == k){
			String str = "";
			for (int temp : print){
				str += temp;
			}
			set.add(Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < n; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			print[depth] = data[i];
			comb(depth+1,index+1);
			visited[i] = false;
		}
	}
}