package done;


import java.io.*;
import java.util.*;

class Boj_2206 {

	class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	Queue<Point> start = new LinkedList<>();
	Queue<Point> end = new LinkedList<>();
	int num_blank = 0;
	int min = Integer.MAX_VALUE;
	int N, M;
	int[][] map;

	void break_wall(int r, int c, int move) {

		if (!(0 <= r && r < N && 0 <= c && c < M)) return;
		if (map[r][c] < 0) { // breakable
			min = Math.min(min, move - map[r][c]);
		}

	}

	boolean visit_start(int r, int c, int move) {
		if (!(0 <= r && r < N && 0 <= c && c < M)) return false;
		if (map[r][c] <= 0) { // movable?
			map[r][c] = move;
			start.add(new Point(r, c));
			if (--num_blank == 0) {
				min = Math.min(min, move);
				return true;
			}
		} else { // breakable?
			break_wall(r - 1, c, move);
			break_wall(r + 1, c, move);
			break_wall(r, c - 1, move);
			break_wall(r, c + 1, move);
		}
		return false;
	}

	boolean visit_end(int r, int c, int move) {
		if (!(0 <= r && r < N && 0 <= c && c < M)) return false;
		if (map[r][c] == 0) { // move
			map[r][c] = move;
			end.add(new Point(r, c));
		}
		return false;
	}

	void bfs() {
		Point p;
		int r, c, move;

		// fill end (negative)
		end.add(new Point(N - 1, M - 1));
		map[N - 1][M - 1] = -1;
		while (!end.isEmpty()) {
			p = end.remove();
			r = p.r;
			c = p.c;
			move = map[r][c] - 1;
			visit_end(r - 1, c, move);
			visit_end(r + 1, c, move);
			visit_end(r, c - 1, move);
			visit_end(r, c + 1, move);

		}
		// start (positive)
		start.add(new Point(0, 0));
		map[0][0] = 1;
		while (!start.isEmpty()) {
			p = start.remove();
			r = p.r;
			c = p.c;
			move = map[r][c] + 1;

			if (visit_start(r - 1, c, move)) return;
			if (visit_start(r + 1, c, move)) return;
			if (visit_start(r, c - 1, move)) return;
			if (visit_start(r, c + 1, move)) return;
		}

	}

	void main_func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];

		for (int i = 0, m = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m = br.read() - '0';
				map[i][j] = m;
				if (m == 0)
					num_blank++;

			}
			br.readLine();
		}

		bfs();
		int ep = map[N-1][M-1];
		if(ep>0 ) min = Math.min(ep, min);
		System.out.println((N * M < min) ? -1 : min);
	}

	public static void main(String[] args) throws IOException {
		new Boj_2206().main_func();
	}

}
