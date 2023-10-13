import java.util.*;
class Solution {
    static int n;
    static int m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        return bfs(maps);
    }
    public int bfs(int[][] maps){
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0,0,1});
        visited= new boolean[n][m];
        visited[0][0] = true;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x == n-1 && y == m-1){
                return cnt;
            }
            for(int i =0;i<dx.length;i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(!(mx>=0 && mx < n && my >= 0 && my < m))
                    continue;
                if(visited[mx][my])
                    continue;
                if(maps[mx][my] == 0)
                    continue;
                visited[mx][my] = true;
                que.offer(new int[]{mx,my,cnt+1});
                
            }
        }
        return -1;
    }
}