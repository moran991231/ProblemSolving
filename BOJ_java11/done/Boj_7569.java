package done;

import java.util.*;
import java.io.*;

class Boj_7569 {

	static int M, N, H;
	static byte[][][] tomato;
	static int unriped_tomato = 0;
	static int day_min = 0;
	static Queue<Point> q = new LinkedList<>();

	static class Point {
		int h, r, c;
		int day;

		Point(int h, int r, int c, int day) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;

		}
	}

	static boolean visit(int h, int r, int c, int day) {
		if (0 <= h && h < H && 0 <= r && r < N && 0 <= c && c < M) {
			if (tomato[h][r][c] == 0) {
				tomato[h][r][c] = 1;
				unriped_tomato--;
				if (unriped_tomato == 0) {
					day_min = day;
					return true;
				}
				q.add(new Point(h, r, c, day));
			}
		}
		return false;

	}

	static void bfs() {
		Point p;
		int h, r, c, day;
		while (!q.isEmpty()) {
			p = q.remove();
			h = p.h;
			r = p.r;
			c = p.c;
			day = p.day + 1;

			if (visit(h - 1, r, c, day)) return;
			if (visit(h + 1, r, c, day)) return;
			if (visit(h, r - 1, c, day)) return;
			if (visit(h, r + 1, c, day)) return;
			if (visit(h, r, c - 1, day)) return;
			if (visit(h, r, c + 1, day)) return;

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		unriped_tomato = 0;
		day_min = 0;
		tomato = new byte[H][N][M];
		q.clear();
		byte t = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					t = Byte.parseByte(st.nextToken());
					tomato[i][j][k] = t;
					if (t == 1)
						q.add(new Point(i, j, k, 0));
					else if (t == 0) unriped_tomato++;

				}
			}
		}
		if (unriped_tomato == 0) {
			day_min = 0;
		} else {
			bfs();
			if (unriped_tomato > 0) day_min = -1;
		}

		System.out.println(day_min);
	}
}
