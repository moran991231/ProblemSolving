
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean[][] makedp(int[] A, int N) {
        boolean[][] dp = new boolean[N + 1][N + 1];
        dp[N][N] = true;
        for (int s = N - 1; 1 <= s; s--) {
            int As = A[s];
            dp[s][s] = true;
            dp[s][s + 1] = As == A[s + 1];
            for (int e = s + 2; e <= N; e++) {
                dp[s][e] = (As == A[e]) && dp[s + 1][e - 1];
            }
        }
        return dp;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = stoi(st.nextToken());

        int M = stoi(br.readLine());

        boolean[][] isPalindrome = makedp(A, N);

        StringBuilder sb = new StringBuilder(M * 2);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = stoi(st.nextToken()), E = stoi(st.nextToken());
            sb.append(isPalindrome[S][E] ? "1\n" : "0\n");
        }
        System.out.println(sb.toString());
    }
}