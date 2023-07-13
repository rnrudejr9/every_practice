package week4.day4;

import java.io.FileInputStream;
import java.util.Scanner;

public class swea_최적경로 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/1247.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            Node[] nodes = new Node[n];
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(x,y);
            }


        }
    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
