
import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] edges;
    static int[] visited;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean bfs(int V, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        int cnt = 1;

        while (!q.isEmpty()) {
            int qsize = q.size();
            cnt *= -1;
            for (int t = 0; t < qsize; t++) {
                int here = q.remove();

                for (int next : edges[here]) {

                    if (visited[next] == 0) {
                        visited[next] = cnt;
                        q.add(next);
                    } else if (visited[next] != cnt) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        int K = stoi(br.readLine());
        StringBuilder sb = new StringBuilder(K * 4);
        for (int k = 0; k < K; k++) {

            st = new StringTokenizer(br.readLine());
            int V = stoi(st.nextToken()), E = stoi(st.nextToken());
            edges = new ArrayList[V + 1];
            visited = new int[V + 1];
            for (int i = 1; i <= V; i++)
                edges[i] = new ArrayList<Integer>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken()), b = stoi(st.nextToken());
                edges[a].add(b);
                edges[b].add(a);
            }
            boolean ret = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    ret = bfs(V, i);
                    if (ret == false)
                        break;
                }
            }

            sb.append(ret ? "YES\n" : "NO\n");

        }
        System.out.println(sb.toString());

    }
}