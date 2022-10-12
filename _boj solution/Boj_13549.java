
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean available(int[] time, int p, int val) {
        if (!(0 <= p && p < 100_001))
            return false;
        return val < time[p];
    }

    public static int lookForDongsang(int N, int K) {
        int[] time = new int[100_001];
        Arrays.fill(time, 100_001);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 0;
        boolean[] inQue = new boolean[100_001];
        inQue[N] = true;

        while (!q.isEmpty()) {
            int qsize = q.size();

            int min_heretime = time[K];

            for (int t = 0; t < qsize; t++) {

                int here = q.remove();

                inQue[here] = false;
                int here_time = time[here];
                min_heretime = Math.min(min_heretime, here_time);
                int next;

                next = 2 * here;
                if (available(time, next, here_time)) {
                    if (inQue[next])
                        continue;
                    time[next] = here_time;
                    inQue[next] = true;
                    q.add(next);
                }
                next = here - 1;
                if (available(time, next, here_time + 1)) {
                    if (inQue[next])
                        continue;
                    time[next] = here_time + 1;
                    inQue[next] = true;
                    q.add(next);
                }
                next = here + 1;
                if (available(time, next, here_time + 1)) {
                    if (inQue[next])
                        continue;
                    time[next] = here_time + 1;
                    inQue[next] = true;
                    q.add(next);
                }

            }
            if (time[K] <= min_heretime)
                break;
        }
        return time[K];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());

        int ret = lookForDongsang(N, K);
        System.out.println(ret);

    }
}