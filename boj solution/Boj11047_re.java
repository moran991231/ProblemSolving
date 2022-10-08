
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
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = stoi(br.readLine());

        int num_coins = 0;
        for (int i = N - 1; 0 <= i; i--) {
            num_coins += K / coins[i];
            K %= coins[i];
            if (K == 0)
                break;
        }
        System.out.println(num_coins);
    }
}