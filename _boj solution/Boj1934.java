
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        int r = a % b;
        if (r == 0)
            return b;
        return gcd(b, r);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder(3 * T);
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken()), B = stoi(st.nextToken());
            sb.append((long) A / (long) gcd(A, B) * (long) B).append('\n');
        }
        System.out.println(sb.toString());
    }
}