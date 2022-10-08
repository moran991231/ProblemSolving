
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static String BFS(boolean[][] edges, int N, int V) {
        StringBuilder sb = new StringBuilder(N * 2);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[V] = true;
        q.add(V);

        while (!q.isEmpty()) {
            int node = q.remove();
            sb.append(node).append(' ');
            for (int i = 1; i <= N; i++) {
                if (edges[node][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return sb.toString();
    }

    static void DFS(boolean[][] edges, boolean[] visited, int node, int N, StringBuilder sb) {

        visited[node] = true;
        sb.append(node).append(' ');

        for (int i = 1; i <= N; i++) {
            if (edges[node][i] && !visited[i]) {
                DFS(edges, visited, i, N, sb);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()), M = stoi(st.nextToken()), V = stoi(st.nextToken());

        boolean[][] edges = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()), b = stoi(st.nextToken());
            edges[a][b] = edges[b][a] = true;
        }
        boolean[] visited = new boolean[N + 1];
        StringBuilder dfs_sb = new StringBuilder(N * 2);
        DFS(edges, visited, V, N, dfs_sb);
        System.out.println(dfs_sb);
        System.out.println(BFS(edges, N, V));

    }
}