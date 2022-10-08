
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int bsearch(long[] wood, long[] wood_sum, int M) {
        int len = wood.length;
        long s = 0, e = wood[len - 1], m;
        int idx;
        long maxHeight = 0;
        long total_wood = wood_sum[len - 1];
        while (s <= e) {
            m = (s + e) / 2L;
            idx = Arrays.binarySearch(wood, m);
            idx = (idx >= 0) ? idx : -(idx + 1);
            long amount = (total_wood - (idx >= 1 ? wood_sum[idx - 1] : 0)) - ((long) (len - idx) * m);

            if (M <= amount) {
                maxHeight = m;
                s = m + 1;
            } else {
                if (e == m)
                    break;
                e = m;
            }
        }
        return (int) maxHeight;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        long[] wood = new long[N], wood_sum = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            wood[i] = stoi(st.nextToken());

        Arrays.sort(wood);
        wood_sum[0] = wood[0];
        for (int i = 1; i < N; i++)
            wood_sum[i] = wood_sum[i - 1] + wood[i];

        int ret = bsearch(wood, wood_sum, M);
        System.out.println(ret);

    }
}