package done;

import java.io.*;
import java.util.*;

class Boj_1260 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] edges;

	static void dfs(int N, int V) {
		boolean[] visited = new boolean[N + 1];
		Stack<Integer> stack = new Stack<Integer>();

		stack.add(V);
		visited[V] = true;
		sb.append(V).append(' ');

		while (true) {
			boolean isNew = false;
			for (int vertex : edges[V]) {
				if (!visited[vertex]) {
					visited[vertex] = true;
					stack.add(vertex);
					sb.append(vertex).append(' ');
					isNew = true;
					break;
				}
			}
			if ((!stack.isEmpty()) && isNew) V = stack.peek();
			else if ((!stack.isEmpty()) && (!isNew)) {
				V = stack.pop();
				if (!stack.isEmpty()) V = stack.peek();
				else break;
			} else break;
		}

	}

	static void bfs(int N, int V) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		sb.append(V).append(' ');
		visited[V] = true;
		while (true) {
			for (int vertex : edges[V]) {
				if (!visited[vertex]) {
					visited[vertex] = true;
					q.add(vertex);
				}
			}
			if (!q.isEmpty()) {
				V = q.remove();
				sb.append(V).append(' ');
			} else break;

		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb.setLength(0);
		int N, M, V;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			edges[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}

		for (int i = 1; i < N; i++)
			Collections.sort(edges[i]);

		dfs(N, V);
		sb.append('\n');
		bfs(N, V);

		System.out.print(sb.toString());

	}

}
