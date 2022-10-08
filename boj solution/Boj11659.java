
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
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = arr[i - 1] + stoi(st.nextToken());

        int i, j;
        StringBuilder sb = new StringBuilder(M * 2);
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            i = stoi(st.nextToken());
            j = stoi(st.nextToken());
            sb.append(arr[j] - arr[i - 1]).append('\n');
        }
        System.out.println(sb.toString());

    }
}