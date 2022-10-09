
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int next, weight;

    public Edge(int n, int w) {
        next = n;
        weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }

}

class Node implements Comparable<Node> {
    int num, path = Main.INF;

    public Node(int n) {
        num = n;
    }

    public int compareTo(Node n) {
        return path - n.path;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Edge>[] edges;
    static Node[] nodes;
    static final int INF = Integer.MAX_VALUE;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void dijkstra(int s, int V) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(nodes[s]);
        nodes[s].path = 0;

        while (!q.isEmpty()) {
            Node n = q.remove();
            int here = n.num;
            int here_val = n.path;

            for (Edge e : edges[here]) {
                Node next = nodes[e.next];
                int weight = e.weight;
                if (here_val + weight < next.path) {
                    next.path = here_val + weight;
                    q.remove(next);
                    q.add(next);

                }
            }
        }

    }

    public static void printPaths(int V) throws IOException {
        StringBuilder sb = new StringBuilder(V * 3);

        for (int i = 1; i <= V; i++) {
            if (nodes[i].path == INF)
                sb.append("INF\n");
            else
                sb.append(nodes[i].path).append('\n');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = stoi(st.nextToken()), E = stoi(st.nextToken());

        nodes = new Node[V + 1];

        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
            nodes[i] = new Node(i);
        }

        int S = stoi(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken()), v = stoi(st.nextToken()), w = stoi(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        // for (int i = 1; i <= V; i++)
        // Collections.sort(edges[i]);

        dijkstra(S, V);
        printPaths(V);

    }
}