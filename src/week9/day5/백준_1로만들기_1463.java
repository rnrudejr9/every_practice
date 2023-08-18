package week9.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_1로만들기_1463 {
	static int[] arr = new int[100_001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int target =1;
		
		BFS(x);
		
		
	}
	public static void BFS(int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,0});
		while(!que.isEmpty()) {
			
			int[] temp = que.poll();
			
			if(temp[0] == 1) {
				System.out.println(temp[1]);
				break;
			}
			
			if(temp[0] % 3 == 0) {
				que.add(new int[] {temp[0]/3,temp[1]+1});
			}
			if(temp[0] % 2 == 0) {
				que.add(new int[] {temp[0]/2,temp[1]+1});
			}
			que.add(new int[] {temp[0]-1,temp[1]+1});
			
		}
	}
}
