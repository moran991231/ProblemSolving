
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int coin_sum(int[] coins, int N, int K) {
        int[] dp = new int[K + 1];
        dp[0] = 1;
        int c;

        for (int i = 0; i < N; i++) {
            c = coins[i];
            for (int k = c; k <= K; k++) {
                dp[k] += dp[k - c];
            }
        }
        return dp[K];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = stoi(br.readLine());
        }
        int ret = coin_sum(coins, N, K);
        System.out.println(ret);
    }
}