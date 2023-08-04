package week7.day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 순서가 중요하고 중복을 허용하는 -> 중복 순열
public class P_신기한소수 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    // 순서가 중요하고 중복을 허용하는 -> 중복 순열
    private static void permutation(int selectedCount, int num) {
        if (selectedCount == N) {
            if (isPrime(num)) sb.append(num + "\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) permutation(selectedCount + 1, next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        permutation(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
