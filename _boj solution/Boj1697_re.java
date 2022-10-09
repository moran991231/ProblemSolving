
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited = new int[100_001];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean available(int loc, int sec) {
        if (!(0 <= loc && loc < 100_001))
            return false;
        return sec < visited[loc];
    }

    static int lookForDongsang(int N, int K) {
        if (N == K)
            return 0;
        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        int sec = 0;
        visited[N] = sec;
        while (!q.isEmpty()) {
            int qsize = q.size();
            sec++;
            for (int t = 0; t < qsize; t++) {
                int here = q.remove();
                if (here == K)
                    return visited[here];
                if (available(here - 1, sec)) {
                    visited[here - 1] = sec;
                    q.add(here - 1);
                }
                if (available(here + 1, sec)) {
                    visited[here + 1] = sec;
                    q.add(here + 1);
                }
                if (available(here * 2, sec)) {
                    visited[here * 2] = sec;
                    q.add(here * 2);
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), K = stoi(st.nextToken());
        Arrays.fill(visited, 100_001);
        System.out.println(lookForDongsang(N, K));
    }
}