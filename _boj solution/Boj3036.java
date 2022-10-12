
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        int r = a % b;
        if (r == 0)
            return b;
        return gcd(b, r);
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] rings = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            rings[i] = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder(N * 4);

        int r0 = rings[0], gcd_r0ri;
        for (int i = 1; i < N; i++) {
            gcd_r0ri = gcd(r0, rings[i]);
            sb.append(r0 / gcd_r0ri).append('/').append(rings[i] / gcd_r0ri).append('\n');
        }
        System.out.println(sb.toString());

    }
}