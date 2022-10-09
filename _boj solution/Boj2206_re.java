
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int WALL = Integer.MAX_VALUE, VISITED_WALL = WALL - 1, EMPTY = 0;
    static final int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
    static int N, M;

    static boolean inMap(int r, int c) {
        return (0 <= r && r < N && 0 <= c && c < M);
    }

    static boolean available(int[][] map, int r, int c) {
        if (!(0 <= r && r < N && 0 <= c && c < M))
            return false;
        return map[r][c] == EMPTY;
    }

    static int breakWall(int[][] map, int r, int c, int path_len) {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i], cc = c + dc[i];
            if (!inMap(rr, cc))
                continue;
            int mapVal = map[rr][cc];
            if (mapVal == WALL || mapVal == EMPTY || mapVal > 0)
                continue;
            int temp = -(mapVal + 1);
            shortest = Math.min(shortest, temp + path_len + 1);
        }
        return shortest;
    }

    static int bfs(int[][] map, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = -1;
        q.add(new int[] { r, c });
        map[r][c] = cnt;

        int shortest = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int qsize = q.size();
            cnt--;

            for (int t = 0; t < qsize; t++) {
                int[] here = q.remove();
                if (here[0] == 0 && here[1] == 0) {
                    shortest = -(cnt + 1);
                }
                for (int i = 0; i < 4; i++) {
                    int rr = here[0] + dr[i], cc = here[1] + dc[i];
                    if (available(map, rr, cc)) {
                        q.add(new int[] { rr, cc });
                        map[rr][cc] = cnt;
                    }
                }
            }
        }
        return shortest;
    }

    static int bfs2(int[][] map, int shortest_nobreak) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;
        q.add(new int[] { 0, 0 });
        map[0][0] = cnt;

        int shortest = shortest_nobreak;

        while (!q.isEmpty()) {
            int qsize = q.size();
            cnt++;
            if (shortest_nobreak <= cnt)
                break;

            for (int t = 0; t < qsize; t++) {
                int[] here = q.remove();

                for (int i = 0; i < 4; i++) {
                    int rr = here[0] + dr[i], cc = here[1] + dc[i];
                    if (!inMap(rr, cc))
                        continue;
                    int mapVal = map[rr][cc];
                    if (mapVal == EMPTY || mapVal < 0) {
                        q.add(new int[] { rr, cc });
                        map[rr][cc] = cnt;

                    } else if (mapVal == WALL) {
                        int temp = breakWall(map, rr, cc, cnt);
                        map[rr][cc] = VISITED_WALL;
                        shortest = Math.min(shortest, temp);
                    }
                }
            }
        }
        return shortest;

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = br.read() == '1' ? WALL : EMPTY;
            }
            br.readLine();
        }

        int shortest_nobreak = bfs(map, N - 1, M - 1);

        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++)
        // if (map[i][j] == WALL || map[i][j] == VISITED_WALL) {
        // System.out.printf(" W ");
        // } else {
        // System.out.printf("%3d ", map[i][j]);

        // }
        // System.out.println();
        // }
        // System.out.println();

        int shortest = bfs2(map, shortest_nobreak);
        shortest = shortest == Integer.MAX_VALUE ? -1 : shortest;

        System.out.println(shortest);

    }
}