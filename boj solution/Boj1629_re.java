
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long power(long A, long B, long C) {
        if (B == 1L)
            return A;
        long temp = 0;
        temp = power(A, B >> 1, C);
        temp = (temp * temp) % C;
        if ((B & 1L) == 0L) {
            return temp;
        } else {
            return (temp * A) % C;
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long A = stoi(st.nextToken()), B = stoi(st.nextToken()), C = stoi(st.nextToken());

        A %= C;
        long ret = 0;
        if (C == 1)
            ret = 0;
        else
            ret = power(A, B, C);
        System.out.println(ret);

    }
}