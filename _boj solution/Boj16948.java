package round5;

import java.io.*;
import java.util.*;

class Boj16948 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dr = { -2, -2, 0, 0, 2, 2 }, dc = { -1, 1, -2, 2, -1, 1 };

	static int N;
	static Point start, target;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean isInMap(int r, int c, int N) {
		if (0 <= r && r < N && 0 <= c && c < N)
			return true;
		return false;
	}

	static class Point {
		int r, c;

		Point(int i, int j) {
			r = i;
			c = j;
		}

		boolean isEqual(Point p) {
			if (r == p.r && c == p.c)
				return true;
			else
				return false;
		}
	}

	static int bfs() {
		Point p;
		int i, j, ti, tj, dist;
		int[][] board = new int[N][N];
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++)
				board[i][j] = Integer.MAX_VALUE;
		}
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		board[start.r][start.c] = 0;
		while (!q.isEmpty()) {
			p = q.remove();
			i = p.r;
			j = p.c;
			dist = board[i][j] + 1;
			for (int k = 0; k < 6; k++) {
				ti = i + dr[k];
				tj = j + dc[k];
				if (!isInMap(ti, tj, N))
					continue;
				if (board[ti][tj] <= dist)
					continue;
				board[ti][tj] = dist;
				q.add(new Point(ti, tj));
			}
		}

		int ret = board[target.r][target.c];
		if(ret==Integer.MAX_VALUE)
			ret=-1;
		return ret;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		start = new Point(stoi(st.nextToken()), stoi(st.nextToken()));
		target = new Point(stoi(st.nextToken()), stoi(st.nextToken()));

		System.out.println(bfs());
	}

}
