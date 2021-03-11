package done;

import java.io.*;
import java.util.*;

class Boj_1753 {
	static int V, E, start;
	static Node[] nodes;
	static List<Edge>[] edges;
	static StringBuilder sb = new StringBuilder();
	static final String inf = "INF\n";

	static class Edge {
		int next, dist;

		Edge(int n, int p) {
			next = n;
			dist = p;
		}
	}

	static class Node implements Comparable<Node> {
		int num, path = Integer.MAX_VALUE;

		Node(int n) {
			num = n;
		}

		public int compareTo(Node n) {
			return this.path - n.path;
		}
	}

	static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<Node>();

		nodes[start].path = 0;
		q.add(nodes[start]);

//		boolean[] isMin = new boolean[V + 1];

		while (!q.isEmpty()) {
			Node n = q.remove();
			int num = n.num, path = n.path;
//			if (isMin[num]) continue;
//			isMin[num] = true;
			for (Edge e : edges[num]) {
				if (path + e.dist < nodes[e.next].path) {
					nodes[e.next].path = path + e.dist;
					q.remove(nodes[e.next]	);
					q.add(nodes[e.next]);
				}
			}

		}

		for (int i = 1; i <= V; i++)
			if (nodes[i].path == Integer.MAX_VALUE)
				sb.append(inf);
			else
				sb.append(nodes[i].path).append('\n');

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb.setLength(0);
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		nodes = new Node[V + 1];
		edges = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			nodes[i] = new Node(i);
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u, v, w;
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v, w));
		}
		dijkstra();
		System.out.println(sb.toString());

	}

}
