package done;

import java.io.*;
import java.util.*;

class Boj_1012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int M, N, K;
	static int[][] map;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int calc() {
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		return cnt;
	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] b = q.remove();
			int i = b[0], j = b[1];
			if (!(inRange(i, 0, M) && inRange(j, 0, N)))
				continue;
			if (map[i][j] == 1)
				continue;
			map[i][j] = 1;

			possibleAdd(i - 1, j, q);
			possibleAdd(i + 1, j, q);
			possibleAdd(i, j - 1, q);
			possibleAdd(i, j + 1, q);

		}
	}

	static boolean inRange(int x, int min, int max) {
		if (min <= x && x < max)
			return true;
		return false;
	}

	static void possibleAdd(int i, int j, Queue<int[]> q) {
		if (!(inRange(i, 0, M) && inRange(j, 0, N)))
			return;
		if (map[i][j] == -1)
			q.add(new int[] { i, j });
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int T = stoi(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			M = stoi(st.nextToken());
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());
			map = new int[M][N];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				map[stoi(st.nextToken())][stoi(st.nextToken())] = -1;
			}

			sb.append(calc()).append('\n');
		}
		System.out.println(sb.toString());
	}

}
