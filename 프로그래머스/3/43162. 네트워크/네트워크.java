import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] dx  ={1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<ArrayList<Integer>> map;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        map = new ArrayList<>();
        for(int i = 0; i<n;i++){
            map.add(new ArrayList<>());
        }
        print(n,computers);
        for(int i = 0 ; i<n;i++){
            if(visited[i])
                continue;
            bfs(i);
            answer++;
        }
        return answer;
    }
    public void bfs(int std){
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(std);
        while(!que.isEmpty()){
            int cur = que.poll();
            visited[cur] = true;
            for(Integer next : map.get(cur)){
                if(visited[next])
                    continue;
                que.offer(next);
            }
        }
    }
    public void print(int n, int[][] computers){
        for(int i =0;i<n;i++){
            for(int j = 0; j< n ; j++){
                if(i == j)
                    continue;
                if(computers[i][j] == 1){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
    }
}