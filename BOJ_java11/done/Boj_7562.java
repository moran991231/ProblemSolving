package done;

import java.io.*;
import java.util.*;

class Boj_7562 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int[] dr = { 1, 1, -1, -1, 2, 2, -2, -2 };
	static final int[] dc = { 2, -2, 2, -2, 1, -1, 1, -1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Point {
		int r, c;

		Point(int x, int y) {
			r = x;
			c = y;
		}

		boolean equals(Point p) {
			if (r == p.r && c == p.c)
				return true;
			else
				return false;
		}
	}

	static boolean inRange(int x, int min, int max) {
		if (0 <= x && x < max)
			return true;
		else
			return false;
	}

	static int bfs(int I, Point start, Point target) {
		int[][] map = new int[I][I];
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		map[start.r][start.c] = 1;

		while (!q.isEmpty()) {
			Point p = q.remove();
			int r = p.r, c = p.c, dd = map[r][c] + 1;
			if (p.equals(target))
				return dd - 2;

			for (int i = 0; i < 8; i++) {
				int rr = r + dr[i], cc = c + dc[i];
				if (inRange(rr, 0, I) && inRange(cc, 0, I)) {
					if (map[rr][cc] == 0) {
						q.add(new Point(rr, cc));
						map[rr][cc] = dd;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int T = stoi(br.readLine());
		for (int i = 0; i < T; i++) {
			int I = stoi(br.readLine());

			st = new StringTokenizer(br.readLine());
			int r1 = stoi(st.nextToken());
			int c1 = stoi(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int r2 = stoi(st.nextToken());
			int c2 = stoi(st.nextToken());
			sb.append(bfs(I, new Point(r1, c1), new Point(r2, c2))).append('\n');
		}
		System.out.println(sb.toString());

	}

}
