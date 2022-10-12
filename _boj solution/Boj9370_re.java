
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int n, path = Main.INF;

    public Node(int n) {
        this.n = n;
    }

    public int compareTo(Node n) {
        return path - n.path;
    }
}

class Edge {
    int next, dist;

    public Edge(int n, int w) {
        next = n;
        dist = w;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Edge>[] edges;
    static int[] targets;
    static final int INF = 5_000_000;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static int[] i2j(int N, int S) {
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++)
            nodes[i] = new Node(i);

        PriorityQueue<Node> q = new PriorityQueue<>();
        nodes[S].path = 0;
        q.add(nodes[S]);

        while (!q.isEmpty()) {
            Node n = q.remove();

            int here = n.n, here_path = n.path;
            for (Edge e : edges[here]) {
                if (here_path + e.dist < nodes[e.next].path) {
                    nodes[e.next].path = here_path + e.dist;
                    q.remove(nodes[e.next]);
                    q.add(nodes[e.next]);
                }
            }
        }
        int[] ret = new int[N + 1];
        for (int i = 1; i <= N; i++)
            ret[i] = nodes[i].path;

        return ret;
    }

    public static String selectTargets(int n, int[] Sto, int[] Gto, int[] Hto, int[] targets, int g, int h) {
        StringBuilder sb = new StringBuilder();
        boolean[] targets_enabled = new boolean[targets.length];
        int gh = Gto[h];
        // s->g->h-> t
        int s_g_h = Sto[g] + gh;
        if (s_g_h < INF) {
            for (int i = 0; i < targets.length; i++) {
                int t = targets[i];
                int h_t = Hto[t];
                if (h_t < INF && Sto[t] == (s_g_h + h_t))
                    targets_enabled[i] = true;
            }
        }

        int s_h_g = Sto[h] + gh;
        if (s_h_g < INF) {
            for (int i = 0; i < targets.length; i++) {
                int t = targets[i];
                int g_t = Gto[t];
                if (g_t < INF && Sto[t] == (s_h_g + g_t))
                    targets_enabled[i] = true;
            }
        }

        for (int i = 0; i < targets.length; i++) {
            if (targets_enabled[i]) {
                sb.append(targets[i]).append(' ');
            }
        }
        // sb.append('\n');

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        int T = stoi(br.readLine());
        for (int _t = 0; _t < T; _t++) {

            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken()), m = stoi(st.nextToken()), t = stoi(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken()), g = stoi(st.nextToken()), h = stoi(st.nextToken());

            edges = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                edges[i] = new ArrayList<>(10);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken()), b = stoi(st.nextToken()), d = stoi(st.nextToken());
                edges[a].add(new Edge(b, d));
                edges[b].add(new Edge(a, d));
            }
            targets = new int[t];

            for (int i = 0; i < t; i++) {
                targets[i] = stoi(br.readLine());
            }
            Arrays.sort(targets);

            int[] Sto = i2j(n, s);
            int[] Gto = i2j(n, g);
            int[] Hto = i2j(n, h);
            String ret = selectTargets(n, Sto, Gto, Hto, targets, g, h);
            System.out.println(ret);

        }

    }
}