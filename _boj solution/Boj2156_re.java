import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int drink_wine(int[] glasses, int N) {
        if (N == 1 || N == 2)
            return glasses[0] + glasses[1];
        int[] dp = new int[N + 1];

        dp[1] = glasses[0];
        dp[2] = glasses[0] + glasses[1];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + glasses[i - 1],
                    Math.max(dp[i - 1], dp[i - 3] + glasses[i - 1] + glasses[i - 2]));
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] glasses = new int[N + 1];
        for (int i = 0; i < N; i++)
            glasses[i] = stoi(br.readLine());

        int ret = drink_wine(glasses, N);
        System.out.println(ret);

    }
}