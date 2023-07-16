import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = 0;
            int arr[][] = new int[3 * N][3 * N];

            for (int i = N; i < 2 * N; i++) {
                for (int j = N; j < 2 * N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }


            for (int i = N; i < 2 * N; i++) {
                for (int j = N; j < 2 * N; j++) {
                    int sum = 0; // sum 값은 기준 좌표가 바뀔때마다 초기화
                    for (int k = -M + 1; k <= M - 1; k++) {
                        sum += arr[i][j + k];
                        sum += arr[i + k][j];
                    }

                    sum -= arr[i][j];

                    max = Math.max(max, sum);

                    sum = 0;

                    for (int k = -M + 1; k <= M - 1; k++) {
                        sum += arr[i + k][j + k];
                        sum += arr[i - k][j + k];
                    }

                    sum -= arr[i][j];

                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}