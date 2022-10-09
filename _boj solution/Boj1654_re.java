import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long cutAndCount(long[] lan, int idx, long size) {
        long cnt = 0;
        for (int i = idx - 1; 0 <= i; i--) {
            if (lan[i] < size)
                break;
            cnt += lan[i] / size;
        }
        for (int i = idx; i < lan.length; i++) {
            cnt += lan[i] / size;
        }
        return cnt;
    }

    static int bsearch(long[] lan, int K, int N) {
        Arrays.sort(lan);
        long maxLan = lan[K - 1];

        long s = 1, e = maxLan, m;
        int idx;
        long maxCut = 1;

        while (s <= e) {
            m = (s + e) / 2;
            idx = Arrays.binarySearch(lan, m);
            idx = (idx < 0) ? (-(idx + 1)) : idx;

            long cnt = cutAndCount(lan, idx, m);
            if (cnt >= (long) N) {
                maxCut = Math.max(maxCut, m);
                s = m + 1;
            } else {
                if (e == m)
                    break;
                e = m;
            }

        }
        return (int) maxCut;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int K = stoi(st.nextToken()), N = stoi(st.nextToken());
        long[] lan = new long[K];
        for (int i = 0; i < K; i++) {
            lan[i] = stoi(br.readLine());
        }
        int ret = bsearch(lan, K, N);
        System.out.println(ret);

    }
}