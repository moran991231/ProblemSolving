
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[][] board;
    static boolean[] col, desc, asc;
    static int DESC_OFFSET;
    static int cnt;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean available(int r, int c) {
        return col[c] && desc[r - c + DESC_OFFSET] && asc[r + c];
    }

    public static void queen(int r, int c, boolean fill) {
        col[c] = fill;
        desc[r - c + DESC_OFFSET] = fill;
        asc[r + c] = fill;
    }

    public static void dfs(int r, int N, int depth) {
        if (depth == 0) {
            cnt++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (available(r, c)) {
                queen(r, c, false);
                dfs(r + 1, N, depth - 1);
                queen(r, c, true);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());

        col = new boolean[N];
        desc = new boolean[2 * N - 1];
        asc = new boolean[2 * N - 1];

        Arrays.fill(col, true);
        Arrays.fill(desc, true);
        Arrays.fill(asc, true);
        DESC_OFFSET = N - 1;
        cnt = 0;

        dfs(0, N, N);
        System.out.println(cnt);

    }
}