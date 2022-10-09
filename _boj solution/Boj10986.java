
import java.io.*;
import java.rmi.Remote;
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

        int presum = 0;
        long[] remainder = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            presum = (presum + Integer.parseInt(st.nextToken())) % M;
            remainder[presum]++;
        }
        st = null;

        long sum = 0;
        if (remainder[0] > 0) {
            sum += (remainder[0] + 1) * remainder[0] / 2;
        }
        for (int i = 1; i < M; i++)
            if (remainder[i] > 0)
                sum += remainder[i] * (remainder[i] - 1) / 2;

        System.out.println(sum);
    }
}