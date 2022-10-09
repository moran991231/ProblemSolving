
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        int[][] table = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                table[i][j] = stoi(st.nextToken()) + table[i][j - 1];
            }
            for (int j = 1; j <= N; j++) {
                table[i][j] += table[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder(M * 2);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken()), y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken()), y2 = stoi(st.nextToken());
            int sum = table[x2][y2] - table[x1 - 1][y2] - table[x2][y1 - 1] + table[x1 - 1][y1 - 1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}