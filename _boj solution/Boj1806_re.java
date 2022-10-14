
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int subsum(int[] A, int N, int S) {
        if (A[N] < S)
            return 0;
        int s = 1, e = 1;
        int temp;
        int minLen = N;
        while (e <= N) {
            temp = A[e] - A[s - 1];
            if (S <= temp) {
                minLen = Math.min(minLen, e - s + 1);
                s++;
            } else {
                e++;
            }

        }
        return minLen;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), S = stoi(st.nextToken());
        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = A[i - 1] + stoi(st.nextToken());
        System.out.println(subsum(A, N, S));

    }
}