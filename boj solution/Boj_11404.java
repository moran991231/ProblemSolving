package done;

import java.io.*;
import java.util.*;

class Boj_11404 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] path;
	static final int PATH_MAX = 100_000_000;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
				}
			}
		}
	}

	static void print_path() {
		StringBuilder sb = new StringBuilder(N * N * 2);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				if (path[i][j] == PATH_MAX) sb.append(0).append(' ');
				else sb.append(path[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		path = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (i == j) path[i][j] = 0;
				else path[i][j] = PATH_MAX;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			path[a][b] = Math.min(path[a][b], c);
		}
		floyd();
		print_path();
	}

}
