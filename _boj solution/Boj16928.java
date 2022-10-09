
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int bfs(int[] edges) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[101];
        visited[0] = true;

        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int t = 0; t < qsize; t++) {
                int here = q.remove();
                if (here == 100) {
                    return cnt;

                }

                for (int i = here + 1; i <= here + 6 && i <= 100; i++) { // roll the dice
                    if (visited[i])
                        continue;
                    int next = edges[i] > 0 ? edges[i] : i;
                    visited[i] = visited[next] = true;
                    q.add(next);

                }

            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        int[] snake_ladder = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()), y = stoi(st.nextToken());
            snake_ladder[x] = (y);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()), y = stoi(st.nextToken());
            snake_ladder[x] = (y);
        }

        System.out.println(bfs(snake_ladder));

    }
}