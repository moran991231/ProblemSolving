
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] edges;
    static int[] visited;
    static int cnt;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static void dfs(int node) {
        visited[node] = cnt++;
        for (int next : edges[node]) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken()), R = stoi(st.nextToken());
        edges = new ArrayList[N + 1];
        visited = new int[N + 1];
        cnt = 1;
        for (int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken()), v = stoi(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(edges[i]);

        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(visited[i]).append('\n');

        System.out.println(sb.toString());

    }
}