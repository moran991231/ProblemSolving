
import java.io.*;
import java.util.*;

import javax.management.Query;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean available(int[] dp, int n) {
        if (0 <= n && n <= 1_000_000) {
            return dp[n] == 0;
        }
        return false;
    }

    public static void makedp() {
        dp = new int[1_000_001];

        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int here = q.remove();

            if (available(dp, here * 3)) {
                dp[here * 3] = here;
                q.add(here * 3);
            }
            if (available(dp, here * 2)) {
                dp[here * 2] = here;
                q.add(here * 2);
            }
            if (available(dp, here + 1)) {
                dp[here + 1] = here;
                q.add(here + 1);
            }

        }
    }

    public static String findShortestPath(int N) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (1 < N) {
            sb.append(N).append(' ');
            N = dp[N];
            cnt++;
        }
        sb.append(1);
        System.out.println(cnt);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        if (dp == null)
            makedp();
        int N = stoi(br.readLine());
        System.out.println(findShortestPath(N));
    }
}

class Num {
    boolean visited = false;
    LinkedList<Integer> path = new LinkedList<>();
    int n;

    public Num(int n) {
        this.n = n;
    }

    public int compareTo(Num p) {
        return (path.size() - p.path.size());
    }

    public void visit() {
        visited = true;
    }

    public void setPath(Num p, int x) {
        visit();
        path = new LinkedList<>(p.path);
        path.add(x);
    }

    public String path2Str() {
        StringBuilder sb = new StringBuilder();
        for (int p : path) {
            sb.append(p).append(' ');
        }
        return sb.toString();
    }

}