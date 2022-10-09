
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static final int DIVISOR = 15746;

    static void make_dp() {
        dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVISOR;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        if (dp == null)
            make_dp();
        int N = stoi(br.readLine());
        System.out.println(dp[N]);

    }
}