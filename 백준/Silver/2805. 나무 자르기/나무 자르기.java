

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] tree = new int [n];
		int max = 0;
		int min = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<n;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		while(min<max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for(int h : tree) {
				//기준값보다 큰 값만 더한다
				if(h - mid > 0) {
					sum += h - mid;
				}
//				길이가 자른 나무를 더한 합
			}
			if(sum < m) {
				max =mid;
			}
//			자른 값이 나무 길이합보다 작으면 높이를 낮춰줘야하므로 배열의 아래쪽을 계산하기위해
//			max 값에 mid 를 주어 다시 이분탐색을 실시함
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}

}
