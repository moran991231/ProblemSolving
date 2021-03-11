package done;

import java.io.*;
import java.util.*;

class Boj_1707 {
	static final String Y = "YES\n", N = "NO\n";
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;

	void paint_bfs(int V, ArrayList<Integer>[] edges) {
		byte[] visited = new byte[V + 1];
		Queue<Integer> q = new LinkedList<>();
		for (int v = 1; v <= V; v++) {
			if (visited[v] != 0) continue;

			q.add(v);
			visited[v] = 1;
			while (!q.isEmpty()) {
				int vertex = q.remove();
				byte color = (byte) (visited[vertex] * -1);

				for (int next : edges[vertex]) {
					if (visited[next] == color) continue;
					else if (visited[next] == 0) {
						visited[next] = color;
						q.add(next);
					} else {
						sb.append(N);
						return;
					}

				}
			}

		}
		sb.append(Y);
		return;

	}

	void main_func() throws IOException {
		sb.setLength(0);
		int K, V, E;
		int a, b;
		ArrayList<Integer>[] edges;
		 K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new ArrayList[V + 1];
			for (int v = 0; v <= V; v++)
				edges[v] = new ArrayList<>();
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			paint_bfs(V, edges);
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		new Boj_1707().main_func();
	}
}
