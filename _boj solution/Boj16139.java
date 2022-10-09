
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int q = stoi(br.readLine());

        int N = str.length();
        int[][] sums = new int[26][N + 1];
        for (int i = 1; i <= N; i++) {
            int ch = str.charAt(i - 1) - 'a';
            for (int alphabet = 0; alphabet < 26; alphabet++) {
                sums[alphabet][i] = sums[alphabet][i - 1] + ((alphabet == ch) ? 1 : 0);

            }

        }
        StringBuilder sb = new StringBuilder(q * 2);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int ch = st.nextToken().charAt(0) - 'a';
            int l = stoi(st.nextToken()), r = stoi(st.nextToken());
            sb.append(sums[ch][r + 1] - sums[ch][l]).append('\n');
        }
        System.out.println(sb.toString());
    }
}