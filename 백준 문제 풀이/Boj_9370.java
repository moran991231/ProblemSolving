package done;

import java.io.*;
import java.util.*;

class Boj_9370 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, t, s, g, h;
	static int[] s_path, h_path, g_path;
	static List<Edge>[] edges;
	static ArrayList<Integer> cand = new ArrayList<>();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Edge {
		int next, dist;

		Edge(int n, int d) {
			next = n;
			dist = d;
		}
	}

	static void read() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		t = stoi(st.nextToken());

		st = new StringTokenizer(br.readLine());
		s = stoi(st.nextToken());
		g = stoi(st.nextToken());
		h = stoi(st.nextToken());

		edges = new ArrayList[n + 1];
		s_path = new int[n + 1];
		g_path = new int[n + 1];
		h_path = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
			s_path[i] = Integer.MAX_VALUE;
			g_path[i] = Integer.MAX_VALUE;
			h_path[i] = Integer.MAX_VALUE;
		}
		cand.clear();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		for (int i = 0; i < t; i++)
			cand.add(stoi(br.readLine()));

	}

	static void dijkstra(int start, int[] x_path) {
		x_path[start] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(
			(a, b) -> x_path[a] - x_path[b]);
		q.add(start);

		while (!q.isEmpty()) {
			int n = q.remove(), path = x_path[n];
			for (Edge e : edges[n]) {
				if (path + e.dist < x_path[e.next]) {
					x_path[e.next] = path + e.dist;
					q.remove(e.next);
					q.add(e.next);
				}
			}

		}
	}

	static void arrange_candidates() {
		for (int i = 0; i < cand.size();) {
			if (s_path[cand.get(i)] == Integer.MAX_VALUE
				|| g_path[cand.get(i)] == Integer.MAX_VALUE)
				cand.remove(i);
			else i++;
		}
	}

	static void check_candidates() {
		int s_g = s_path[g], s_h = s_path[h], g_h = g_path[h];
		int c;
		for (int i = 0; i < cand.size();) {
			c = cand.get(i);
			if (s_path[c] == (s_g + g_h + h_path[c])
				|| s_path[c] == (s_h + g_h + g_path[c]))
				i++;
			else cand.remove(i);
		}
	}

	static void print_candidates() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(cand);
		for (int n : cand)
			sb.append(n).append(' ');
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			read();
			dijkstra(s, s_path);
			dijkstra(g, g_path);
			dijkstra(h, h_path);
			arrange_candidates();
			check_candidates();
			print_candidates();
		}

	}

}
