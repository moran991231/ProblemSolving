package done;

import java.io.*;
import java.util.*;

class Boj_1956 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	static int[][] path;
	static final int PATH_MAX = 40_000_000;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void floyd() {
		for (int k = 1; k <= V; k++)
			for (int i = 1; i <= V; i++)
				for (int j = 1; j <= V; j++)
					path[i][j] = Math.min(path[i][k] + path[k][j], path[i][j]);
	}

	static int getMinCycle() {
		int min = PATH_MAX;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++)
				if (i == j) continue;
				else min = Math.min(min, path[i][j] + path[j][i]);
		}
		if (min == PATH_MAX) return -1;
		return min;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		path = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++)
				if (i == j) path[i][j] = 0;
				else path[i][j] = PATH_MAX;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			path[a][b] = Math.min(path[a][b], c);
		}

		floyd();
		System.out.println(getMinCycle());
	}

}
