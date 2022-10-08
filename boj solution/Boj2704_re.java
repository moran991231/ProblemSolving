
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = stoi(st.nextToken());
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = stoi(st.nextToken());
            }
        }

        int[][] C = new int[N][K];
        for (int i = 0; i < N; i++) {
            int[] a = A[i];

            for (int k = 0; k < K; k++) {
                int temp = 0;
                for (int j = 0; j < M; j++) {
                    temp += a[j] * B[j][k];
                }
                C[i][k] = temp;
            }
        }
        A = B = null;
        StringBuilder sb = new StringBuilder(N * K * 2);
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < K; k++) {
                sb.append(C[i][k]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}