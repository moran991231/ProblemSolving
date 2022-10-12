
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final String FACTOR = "factor\n", MULTIPLE = "multiple\n", NEITHER = "neither\n";

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken()), M = stoi(st.nextToken());
            if (N == 0 && M == 0)
                break;
            if (M % N == 0)
                sb.append(FACTOR);
            else if (N % M == 0)
                sb.append(MULTIPLE);
            else
                sb.append(NEITHER);
        }
        System.out.println(sb.toString());

    }
}