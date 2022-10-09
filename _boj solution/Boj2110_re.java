
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean canInstallEnough(int[] home, int N, int C, int minLen) {
        C--; // install one in the first home
        int pre = 0, cur = 1;
        while (0 < C && cur < N) {
            if (minLen <= home[cur] - home[pre]) {
                C--; // install
                pre = cur;
            }
            cur++;
        }
        return C == 0;
    }

    static int install(int[] home, int N, int C) {
        int s = 1, e = home[N - 1] - home[0], m;
        // for (int i = 1; i < N; i++) {
        // s = Math.min(s, home[i] - home[i - 1]);
        // }
        if (C == 2)
            return e;
        // if (C == N)
        // return s;

        int ret = s;

        while (s <= e) {
            m = (s + e) / 2;

            if (canInstallEnough(home, N, C, m)) {
                ret = Math.max(ret, m);
                s = m + 1;
            } else {
                if (e == m)
                    break;
                e = m;
            }

        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), C = stoi(st.nextToken());
        int[] home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = stoi(br.readLine());
        }
        Arrays.sort(home);
        // for (int x : home)
        // System.out.print(x + " ");
        // System.out.println();

        int ret = install(home, N, C);
        System.out.println(ret);

    }
}