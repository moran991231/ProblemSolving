
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static ArrayList<Long> combinations(long[] items, int s, int e) {
        ArrayList<Long> lst = new ArrayList<>(1 << (e - s));
        lst.add(0l);
        for (int i = s; i < e; i++) {
            int size = lst.size();
            long item = items[i];
            for (int j = 0; j < size; j++) {
                lst.add(lst.get(j) + item);
            }
        }
        return lst;
    }

    static int upperBound(List<Long> lst, long target) {
        int len = lst.size();
        int s = 0, e = len - 1, m;
        long lm;
        while (s <= e) {
            m = (s + e + 1) / 2;
            lm = lst.get(m);
            if (lm <= target) {
                if (s == m) {
                    return s;
                }
                s = m;
            } else {
                e = m - 1;
            }
        }
        return e;
    }

    static int packing(long[] items, int N, int C) {
        ArrayList<Long> g1 = combinations(items, 0, (N) / 2);
        ArrayList<Long> g2 = combinations(items, (N) / 2, N);
        Collections.sort(g2);
        int cnt = 0;
        for (long comb1 : g1) {
            int idx = upperBound(g2, C - comb1);
            cnt += idx + 1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), C = stoi(st.nextToken());
        long[] items = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            items[i] = stoi(st.nextToken());

        int ret = packing(items, N, C);
        System.out.println(ret);

    }
}