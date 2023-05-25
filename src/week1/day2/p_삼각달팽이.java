package week1.day2;

import java.util.ArrayList;

public class p_삼각달팽이 {

    static Integer[][] map;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    public int[] solution(int n) {
        int[] answer = {};
        dx = new int[]{1,0,-1};
        dy = new int[]{0,1,-1};
        map = new Integer[n][n];
        visited = new boolean[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 0;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j =i+1;j<n;j++){
                visited[i][j] = true;
            }
        }

        dfs(0,0,1);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(map[i][j] != 0) {
                    list.add(map[i][j]);
                }
            }
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }


    public static void dfs(int x,int y,int value){
        if(!visited[x][y]){
            visited[x][y] = true;
            map[x][y] = value;
            value = value +1;
            for(int i =0;i<dx.length;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx >= 0 && mx < map.length && my >= 0 && my < map.length && map[mx][my] == 0){
                    dfs(mx,my,value);
                }
            }
        }
    }
    public static void main(String[] args) {
        p_삼각달팽이 p = new p_삼각달팽이();
        p.solution(4);
    }
}


