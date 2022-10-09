package done;

import java.io.*;
import java.util.*;

class Boj_2178 {
	static int N, M;
	static char[][] maze;
	static int min = Integer.MAX_VALUE;

	static boolean isEnabled(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return maze[r][c] == '1' ? true : false;
		return false;
	}

	/*
	 * static void dfs(int r, int c, int depth) { if (r == N - 1 && c == M - 1) {
	 * min = Math.min(min, depth); return; } if (min <= depth) return; maze[r][c] =
	 * '0'; if (isEnabled(r - 1, c)) dfs(r - 1, c, depth + 1); if (isEnabled(r, c -
	 * 1)) dfs(r, c - 1, depth + 1); if (isEnabled(r + 1, c)) dfs(r + 1, c, depth +
	 * 1); if (isEnabled(r, c + 1)) dfs(r, c + 1, depth + 1);
	 * 
	 * maze[r][c] = '1'; }
	 */
	static class Point {
		int r, c;
		char dist;

		Point(int r, int c, char dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static boolean visit(int r, int c, char dist, Queue<Point> q) {
		if (isEnabled(r, c)) {
			maze[r][c] = '0';
			if (r == N - 1 && c == M - 1) {
				min = dist;
				return true;
			}
			q.add(new Point(r, c, dist));
			return false;
		}
		return false;
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int r = 0, c = 0;
		char dist = 1;
		q.add(new Point(r, c, dist));
		maze[0][0] = '0';
		while (true) {
			Point p;
			if (q.isEmpty())
				break;
			else p = q.remove();
			r = p.r;
			c = p.c;
			dist = (char) (p.dist + 1);
			if (visit(r - 1, c, dist, q)) return;
			if (visit(r + 1, c, dist, q)) return;
			if (visit(r, c - 1, dist, q)) return;
			if (visit(r, c + 1, dist, q)) return;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		{
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
		}
		maze = new char[N][];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++)
			maze[i] = br.readLine().toCharArray();

		bfs();
		System.out.println(min);

	}

}
