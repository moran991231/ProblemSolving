package done;

import java.io.*;
import java.util.*;

class Boj_1197 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;

	static int V, E;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int a, b;
		int cost;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			cost = c;
		}

		public int compareTo(Edge d) {
			return (int) (cost - d.cost);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static long Kruskal() {
		long cost=0;

		while (!edges.isEmpty()) {
			Edge e = edges.remove();
			int root_a = find(e.a), root_b = find(e.b);
			if (root_a == root_b) continue;

			parent[root_b] = root_a;
			cost += e.cost;
		}

		return cost;

	}

	static int find(int x) {
		int p = x;
		while (parent[p] != p)
			p = parent[p];
		parent[x] = p;
		return p;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		V = stoi(st.nextToken());
		E = stoi(st.nextToken());

		edges.clear();
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) { parent[i] = i; }

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			edges.add(new Edge(a, b, c));
		}

		System.out.println(Kruskal());

	}

}
