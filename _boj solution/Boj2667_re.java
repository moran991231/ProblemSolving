
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean available(char[][] map, int N, int r, int c) {
        if (!(0 <= r && r < N && 0 <= c && c < N))
            return false;
        return map[r][c] == '1';
    }

    public static int bfs(char[][] map, int N, int r, int c) {
        int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        map[r][c] = '0';
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] here = q.remove();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int rr = here[0] + dr[i], cc = here[1] + dc[i];
                if (available(map, N, rr, cc)) {
                    q.add(new int[] { rr, cc });
                    map[rr][cc] = '0';
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        int N = stoi(br.readLine());
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        int cnt = 0;
        ArrayList<Integer> num_house = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1') {
                    cnt++;
                    num_house.add(bfs(map, N, i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append('\n');
        Collections.sort(num_house);
        for (int i = 0; i < num_house.size(); i++)
            sb.append(num_house.get(i)).append('\n');
        System.out.println(sb.toString());
    }

}