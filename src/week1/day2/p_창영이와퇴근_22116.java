package week1.day2;

import utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_창영이와퇴근_22116 {
    static int n;

    public static class Graph{
        private int n;
        private int maps[][];
        public Graph(int n){
            this.n = n;
            maps = new int[n][n];
            for(int i =0;i<n;i++){
                for (int j = 0; j < n; j++) {
                    maps[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        public void input(int i,int j,int w){
            maps[i][j] = w;
            maps[j][i] = w;
        }
        public void dijkstra(int v){
            int distance[] = new int[n];
            boolean[] check = new boolean[n];
            for(int i=0;i<n;i++){
                distance[i] = Integer.MAX_VALUE;
            }
            distance[v] = 0;
            check[v] = true;

            for(int i=0; i<n; ++i){
                if(distance[i] == 2147483647) System.out.print("∞ ");
                else System.out.print(distance[i]+" ");
            }
            System.out.println("");

            // 연결노드 distance갱신
            for(int i=0; i<n; ++i){
                if(!check[i] && maps[v][i] != Integer.MAX_VALUE){
                    distance[i] = maps[v][i];
                }
            }

            // 결과값 출력
            for(int i=0; i<n; ++i){
                if(distance[i] == 2147483647) System.out.print("∞ ");
                else System.out.print(distance[i]+" ");
            }
            System.out.println("");

            for(int a=0; a<n-1; ++a){
                // 원래는 모든 노드가 true될때까지 인데
                // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
                // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
                int min = Integer.MAX_VALUE;
                int min_index = -1;

                // 노드 최소값 찾기
                for(int i=0; i<n; ++i){
                    if(!check[i]){
                        if(distance[i] < min){
                            min = distance[i];
                            min_index = i;
                        }
                    }
                }

                // 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인한다.
                check[min_index] = true;
                for(int i=0; i<n; ++i){
                    if(!check[i] && maps[min_index][i] != Integer.MAX_VALUE){
                        if(distance[min_index] + maps[min_index][i] < distance[i]){
                            distance[i] = distance[min_index] + maps[min_index][i];
                        }
                    }
                }

                // 결과값 출력
                for(int i=0; i<n; ++i){
                    if(distance[i] == 2147483647) System.out.print("∞ ");
                    else System.out.print(distance[i]+" ");
                }
                System.out.println("");
            }


        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n);
        for(int i=0;i<n;i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph.input(i,j,Integer.parseInt(st.nextToken()));
            }
        }
        graph.dijkstra(0);


    }
}
