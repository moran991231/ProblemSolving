import java.io.*;
import java.util.*;

class Boj1012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int M, N;
	static boolean[][] farm;
	static final int[] dx = { -1, +1, 0, 0 }, dy = { 0, 0, -1, +1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void findBaechu(int r, int c, Queue<int[]> q) {
		if (r < 0 || M <= r || c < 0 || N <= c)
			return;

		if (farm[r][c] == false)
			return;
		farm[r][c] = false;
		q.add(new int[] { r, c });
		return;

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		farm[r][c] = false;
		q.add(new int[] { r, c });
		int[] baechu;
		while (!q.isEmpty()) {
			baechu = q.remove();
			for (int i = 0; i < 4; i++)
				findBaechu(baechu[0] + dx[i], baechu[1] + dy[i], q);
		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int T = stoi(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = stoi(st.nextToken());
			N = stoi(st.nextToken());
			int K = stoi(st.nextToken());
			farm = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				farm[stoi(st.nextToken())][stoi(st.nextToken())] = true;
			}
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++)
					if (farm[i][j]) {
						bfs(i, j);
						cnt++;
					}
			}

			sb.append(cnt).append('\n');
		}

		System.out.print(sb.toString());
	}
}
