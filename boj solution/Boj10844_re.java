
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int DIVISOR = 1_000_000_000;
    static int[][] dp;
    static int[] num_steps = new int[101];

    static void make_dp() {
        dp = new int[101][10];

        for (int end = 1; end <= 9; end++)
            dp[1][end] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][8] = dp[i - 1][9];

            for (int end = 1; end < 9; end++) {
                dp[i][end - 1] = (dp[i][end - 1] + dp[i - 1][end]) % DIVISOR;
                dp[i][end + 1] = (dp[i][end + 1] + dp[i - 1][end]) % DIVISOR;
            }
        }

        int sum;
        for (int i = 1; i <= 100; i++) {
            sum = 0;
            for (int end = 0; end <= 9; end++) {
                sum = (sum + dp[i][end]) % DIVISOR;
            }
            num_steps[i] = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        if (dp == null)
            make_dp();
        int N = stoi(br.readLine());
        System.out.println(num_steps[N]);

    }
}