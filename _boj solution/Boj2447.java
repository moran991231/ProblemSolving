
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int[] dr = { 0, 0, 0, 1, 1, 2, 2, 2 }, dc = { 0, 1, 2, 0, 2, 0, 1, 2 };

    static void drawStar(char[][] sky, int N, int r, int c) {
        if (N == 3) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    sky[i][j] = '*';
                }
            }
            sky[r + 1][c + 1] = ' ';
            return;
        }
        N /= 3;
        for (int i = 0; i < 8; i++) {
            drawStar(sky, N, r + dr[i] * N, c + dc[i] * N);
        }

        for (int i = r + N; i < r + N * 2; i++) {
            for (int j = c + N; j < c + N * 2; j++) {
                sky[i][j] = ' ';
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        char[][] sky = new char[N][N];
        StringBuilder sb = new StringBuilder(N * (N + 1));
        drawStar(sky, N, 0, 0);
        for (char[] line : sky)
            sb.append(line).append('\n');
        System.out.println(sb.toString());
    }
}