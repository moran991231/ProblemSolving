
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static Path[][] p;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void floyd_warshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    p[i][j].update(p[i][k], p[k][j]);
                }
            }
        }

    }

    public static void printCost() {
        StringBuilder sb = new StringBuilder(N * N * 2);
        StringBuilder sb2 = new StringBuilder(N * N * 10);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (p[i][j].cost == Path.TOO_FAR || i == j) {
                    sb.append(0).append(' ');
                    sb2.append(0).append('\n');
                } else {
                    sb.append(p[i][j].cost).append(' ');
                    p[i][j].buildPath(sb2);
                }

            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
        System.out.print(sb2.toString());
    }

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        M = stoi(br.readLine());

        p = new Path[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                p[i][j] = new Path();
            p[i][i] = new Path(i, i, 0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken()), c = stoi(st.nextToken());
            Path temp = new Path(a, b, c);
            if (p[a][b].compareTo(temp) > 0) {
                p[a][b] = temp;
            }
        }

        floyd_warshall();
        printCost();

    }

}

class Path implements Comparable<Path> {
    static final int TOO_FAR = 20_000_000;
    // int src, dst;
    int cost = TOO_FAR;
    LinkedList<Integer> route = new LinkedList<>();

    public Path() {
    };

    public Path(int src, int dst, int cost) {
        route.add(src);
        route.add(dst);
        this.cost = cost;
    }

    public void update(Path p1, Path p2) {
        if (p1.cost + p2.cost < cost) {
            cost = p1.cost + p2.cost;
            route = new LinkedList<>(p1.route);
            route.removeLast();
            route.addAll(p2.route);
        }
    }

    public int numCities() {
        return Math.min(0, route.size() - 1);
    }

    public int compareTo(Path p) {
        return cost - p.cost;
    }

    public void buildPath(StringBuilder sb) {
        sb.append(route.size()).append(' ');
        for (int city : route)
            sb.append(city).append(' ');
        sb.append('\n');

    }

}
