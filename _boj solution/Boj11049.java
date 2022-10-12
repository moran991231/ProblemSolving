
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[][] dp; // dp[i][j]: mat[i] ~ mat[j]을 계산하는데 필요한 곱셈 연산의 최소 횟수

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long calc(int[] mat, int N) {

        dp = new long[N][N];
        for (int i = N - 2; 0 <= i; i--) {
            Arrays.fill(dp[i], i + 2, N, Integer.MAX_VALUE);
            dp[i][i + 1] = mat[i] * mat[i + 1] * mat[i + 2];
            for (int j = i + 2; j < N; j++) {
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] // MxN: mat[i] ~ mat[k]
                                    + dp[k + 1][j] // NxS: mat[k+1] ~ mat[j]
                                    + mat[i] * mat[k + 1] * mat[j + 1]); // M*N*S
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] mat = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mat[i] = stoi(st.nextToken());
            if (i == N - 1)
                mat[i + 1] = stoi(st.nextToken());
        }
        long ret = calc(mat, N);
        System.out.println(ret);

    }
}