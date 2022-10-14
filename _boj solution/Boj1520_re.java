
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };

    static int walkDown(short[][] map, PriorityQueue<Node> pq, int N, int M) {
        int[][] dp = new int[N + 2][M + 2]; // dp[i][j]: (1,1) ~(i,j)이동 경우의수
        dp[1][1] = 1;
        while (!pq.isEmpty()) {
            Node n = pq.remove();
            int r = n.i, c = n.j;
            short map_rc = map[r][c];
            int dp_rc = dp[r][c];

            for (int i = 0; i < 4; i++) {
                int rr = r + dr[i], cc = c + dc[i];
                if (map_rc > map[rr][cc])
                    dp[rr][cc] += dp_rc;
            }

        }

        return dp[N][M];
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>(N * M);
        short[][] map = new short[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Short.parseShort(st.nextToken());
                pq.add(new Node(i, j, map[i][j]));
            }
        }
        int ret = walkDown(map, pq, N, M);
        System.out.println(ret);

    }
}

class Node implements Comparable<Node> {
    int i, j, height;

    public Node(int i, int j, int h) {
        this.i = i;
        this.j = j;
        height = h;
    }

    public int compareTo(Node n) {
        return n.height - height;
    }

}