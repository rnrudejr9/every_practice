import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int[] cleaner = new int[2]; 
	static LinkedHashSet<int[]> spreadList = new LinkedHashSet<>();
	static Queue<int[]> que = new ArrayDeque<>();
	static int[][] plusMap;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] rx = {0,-1,0,1};
	static int[] ry = {1,0,-1,0};
	static int[] drx = {0,1,0,-1};
	static int[] dry = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		plusMap = new int[R][C];
		int temp = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) {
					spreadList.add(new int[] {i,j});
				}
				if(map[i][j] == -1) {
					cleaner[temp++] = i;
				}
			}
			
		}
		for (int i = 0; i < T; i++) {
			spread();
			upRoll(cleaner[0], 0, 0, 0);
			downRoll(cleaner[1], 0, 0, 0);
		}	
		
		System.out.println(getAnswer());
	}

	public static int getAnswer() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1)
					continue;
				sum += map[i][j];
			}
		}
		return sum;
	}
	public static void downRoll(int x,int y,int dir,int temp) {
		int mx = x + drx[dir];
		int my = y + dry[dir];
		if(!outOfBoundCheck(mx,my)) {
			downRoll(x,y,(dir+1)%4,temp);
		}else {
			if(map[mx][my] == -1) {
				return;
			}
			int next = map[mx][my];
			map[mx][my] = temp;
			downRoll(mx,my,dir,next);
		}
	}
	
	public static void upRoll(int x,int y,int dir,int temp) {
		int mx = x + rx[dir];
		int my = y + ry[dir];
		if(!outOfBoundCheck(mx,my)) {
			upRoll(x,y,(dir+1)%4,temp);
		}else {
			if(map[mx][my] == -1) {
				return;
			}
			int next = map[mx][my];
			map[mx][my] = temp;
			upRoll(mx,my,dir,next);
		}
		
	}
	private static boolean outOfBoundCheck(int mx, int my) {
		// TODO Auto-generated method stub
		return mx >= 0 && mx < R && my >= 0 && my < C;
	}

	public static void spread() {
		List<int[]> tempList = new ArrayList<>();
		plusMap = new int[R][C];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] > 0) {
					int spreadSize = map[i][j] / 5;
					for (int k = 0; k < dx.length; k++) {
						int mx = i + dx[k];
						int my = j + dy[k];
						if (check(mx, my)) {
							plusMap[mx][my] += spreadSize;
							map[i][j] -= spreadSize;
						}
					}	
				}
			}
			
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += plusMap[i][j];
			}
		}
		
		for(int[] tempData : tempList) {
			spreadList.add(tempData);
		}
	}
	private static boolean check(int mx, int my) {
		return mx >= 0 && mx < R && my >= 0 && my < C && map[mx][my] >= 0;
	}
}