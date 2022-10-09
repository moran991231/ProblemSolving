import java.io.*;
import java.util.*;

class Boj2206_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int[] dr = { 0, 0, -1, 1 }, dc = { -1, 1, 0, 0 };
	static final int WALL = Integer.MAX_VALUE;

	static int N, M;
	static int[][] map;
	static int min;

	static class Point {
		int r, c, len;
		boolean isWall = false;

		Point(int i, int j, int l) {
			r = i;
			c = j;
			len = l;
		}

		Point(int i, int j, int l, boolean w) {
			r = i;
			c = j;
			len = l;
			isWall = w;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean inRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}

	static void bfs1(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		map[r][c] = -1;
		q.add(new int[] { r, c });
		int cnt, rr, cc, len = -1;

		int[] p;
		while (!q.isEmpty()) {
			len--;
			cnt = q.size();
			for (int n = 0; n < cnt; n++) {
				p = q.remove();
				for (int i = 0; i < 4; i++) {
					rr = p[0] + dr[i];
					cc = p[1] + dc[i];
					if (!inRange(rr, cc))
						continue;
					if (map[rr][cc] == WALL || map[rr][cc] < 0)
						continue;
					map[rr][cc] = len;
					q.add(new int[] { rr, cc });
				}

			}

		}
	}

	static void bfs2(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		map[r][c] = 1;
		q.add(new Point(r, c, 1));
		int cnt, rr, cc, len;

		Point p;
		while (!q.isEmpty()) {
			p = q.remove();
			for (int i = 0; i < 4; i++) {
				rr = p.r + dr[i];
				cc = p.c + dc[i];
				len = p.len + 1;
				if (!inRange(rr, cc))
					continue;
				 if (map[rr][cc] == WALL) {
					if (p.isWall)
						continue;
					q.add(new Point(rr, cc, len, true));
					continue;
				} else if (map[rr][cc] == 0) {
					if (p.isWall)
						continue;
					map[rr][cc] = len;
					q.add(new Point(rr, cc, len));
					continue;
				}
				else if (map[rr][cc] > 0)
					continue;
				// else map[rr][cc]<0
				min = Math.min(min, len - map[rr][cc] - 1);
				if (p.isWall)
					continue;

				map[rr][cc] = len;
				q.add(new Point(rr, cc, len));
			}

		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		min = Integer.MAX_VALUE;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (str.charAt(j) - '0') == 0 ? 0 : WALL;
			}
		}

		bfs1(N - 1, M - 1);
		bfs2(0, 0);
		if (N == 1 && M == 1)
			min = 1;
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}
}
