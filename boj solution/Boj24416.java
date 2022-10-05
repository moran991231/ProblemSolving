
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int code1, code2;

    static int fib_recur(int n) {
        if (n == 1 || n == 2) {
            code1++;
            return 1;
        } else
            return fib_recur(n - 1) + fib_recur(n - 2);
    }

    static int fib_dp(int n) {
        if (n == 1 || n == 2)
            return 1;
        int fi_1 = 1, fi_2 = 0, fi = 1;
        for (int i = 3; i <= n; i++) {
            fi_2 = fi_1;
            fi_1 = fi;
            fi = fi_2 + fi_1;
            code2++;
        }
        return fi;

    }

    public static void main(String[] args) throws IOException {
        code1 = code2 = 0;
        int N = stoi(br.readLine());
        fib_recur(N);
        fib_dp(N);

        System.out.printf("%d %d\n", code1, code2);

    }
}