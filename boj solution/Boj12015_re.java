
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int readInt() throws IOException {
        int n = 0;
        int ch;
        while ('0' <= (ch = br.read()) && ch <= '9') {
            n = n * 10 + ch - '0';
        }
        return n;
    }

    public static int findInsertIdx(int[] lis, int len, int target) {
        int s = 0, e = len - 1, m = 0;
        if (target <= lis[0] || len == 0)
            return 0;
        if (lis[len - 1] < target)
            return len;

        while (s <= e) {
            m = (s + e) / 2;
            if (lis[m] == target)
                return m;
            if (target < lis[m]) {
                if (e == m)
                    break;
                e = m;
            } else {
                s = m + 1;
            }
        }

        return m;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        int[] A = new int[N], lis = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int a = readInt();
            int idx = findInsertIdx(lis, len, a);
            if (idx == len) {
                lis[len++] = a;
            } else {
                lis[idx] = a;
            }
        }
        System.out.println(len);

    }
}