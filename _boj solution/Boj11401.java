
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final long DIVISOR = 1_000_000_007l;

    static long power(long base, int a) {
        if (a == 1)
            return base;
        long temp = power(base, a / 2);
        temp = (temp * temp) % DIVISOR;
        if ((a & 1) == 0)
            return temp;
        else
            return (temp * base) % DIVISOR;
    }

    static long multiply(int from, int to) {
        long ret = 1;
        for (long n = from; n <= to; n++) {
            ret = (ret * n) % DIVISOR;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer((br.readLine()));
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());
        K = Math.min(K, N - K);
        long ret = 0;
        if (K == 0) {
            ret = 1;
        } else if (K == 1) {
            ret = N;
        } else {
            long numerator = multiply(N - K + 1, N);
            long denominator = multiply(1, K);
            long denom_power = power(denominator, (int) DIVISOR - 2);
            ret = (numerator * denom_power) % DIVISOR;
        }

        System.out.println(ret);

    }
}