package round5;

import java.io.*;
import java.util.*;

class Boj1786 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] map;
	static ArrayList<Point> sharks;
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Point {
		int r, c;

		Point(int i, int j) {
			r = i;
			c = j;
		}
	}

	static boolean isInMap(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}

	static int bfs() {
		Point p;
		int dist = 0;
		int i, j, ti, tj;
		Queue<Point> q = new LinkedList<>();
		for (Point sh : sharks) {
			q.add(sh);
		}
		while (!q.isEmpty()) {
			p = q.remove();
			i = p.r;
			j = p.c;
			if (map[i][j] == -1)
				dist = 1;
			else
				dist = map[i][j] + 1;

			for (int k = 0; k < 8; k++) {
				ti = i + di[k];
				tj = j + dj[k];
				if (!isInMap(ti, tj))
					continue;
				if (map[ti][tj] == -1)
					continue;
				if (map[ti][tj] == 0 || dist < map[ti][tj]) {
					map[ti][tj] = dist;
					q.add(new Point(ti, tj));
				}

			}

		}

		int max = 0;
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				if (map[i][j] > max)
					max = map[i][j];
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		sharks = new ArrayList<Point>();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (stoi(st.nextToken()) == 1) {
					map[i][j] = -1;
					sharks.add(new Point(i, j));
				}
			}
		}
		int ret = 0;
//		if(sharks.size()<N*M)
		ret = bfs();
		System.out.println(ret);
	}

}
