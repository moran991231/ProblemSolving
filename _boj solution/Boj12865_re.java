
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int knapsack(int N, int K, int[] w, int[] v) {
        if (N == 0)
            return 0;
        int[][] sack = new int[N][K + 1];

        Arrays.fill(sack[0], w[0], K + 1, v[0]);

        for (int i = 1; i < N; i++) {
            for (int k = 0; k < w[i]; k++)
                sack[i][k] = sack[i - 1][k];
            for (int k = w[i]; k <= K; k++) {
                sack[i][k] = Math.max(sack[i - 1][k], sack[i - 1][k - w[i]] + v[i]);
            }
        }

        int max = 0;
        for (int k = 1; k <= K; k++)
            max = Math.max(max, sack[N - 1][k]);

        return sack[N - 1][K];

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());
        int[] w = new int[N], v = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = stoi(st.nextToken());
            v[i] = stoi(st.nextToken());
            if (w[i] > K) {
                N--;
                i--;
            }
        }

        int ret = knapsack(N, K, w, v);
        System.out.println(ret);
    }
}