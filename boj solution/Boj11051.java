
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[][] tri = null;
    static final int DIVISOR = 10_007;

    static int nCk(int n, int k) {
        if (n - k < k)
            return nCk(n, n - k);
        return tri[n][k];
    }

    static void makeTri() {
        tri = new int[1001][];
        for (int i = 0; i < 1001; i++) {
            tri[i] = new int[(i + 2) / 2];
            tri[i][0] = 1;

            for (int j = 1; j < tri[i].length; j++) {
                tri[i][j] = (nCk(i - 1, j - 1) + nCk(i - 1, j)) % DIVISOR;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        if (tri == null)
            makeTri();

        st = new StringTokenizer(br.readLine());
        System.out.println(nCk(stoi(st.nextToken()), stoi(st.nextToken())));
    }
}