
import java.io.*;
import java.util.*;

class Edge {
    int next, dist;

    public Edge(int n, int d) {
        next = n;
        dist = d;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] path;
    static final int INF = 800_000 * 2;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void floyd(int N) {
        for (int i = 1; i <= N; i++)
            path[i][i] = 0;

        for (int v = 1; v <= N; v++) {
            for (int i = 1; i <= N; i++) {
                if (i == v)
                    continue;
                for (int j = i + 1; j <= N; j++) {
                    if (path[i][v] + path[v][j] < path[i][j]) {
                        path[i][j] = path[j][i] = path[i][v] + path[v][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), E = stoi(st.nextToken());
        path = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(path[i], INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken()), c = stoi(st.nextToken());
            path[a][b] = path[b][a] = c;

        }
        st = new StringTokenizer(br.readLine());
        int v1 = stoi(st.nextToken()), v2 = stoi(st.nextToken());

        floyd(N);
        int route1 = path[1][v1] + path[v1][v2] + path[v2][N];
        int route2 = path[1][v2] + path[v2][v1] + path[v1][N];
        // System.out.println(route1 + " " + route2);
        route1 = Math.min(route1, route2);
        route1 = route1 >= INF ? -1 : route1;
        System.out.println(route1);
    }
}