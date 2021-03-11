package done;

import java.io.*;
import java.util.*;

class Boj_2667 {

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;
	static ArrayList<Integer> houses = new ArrayList<>();

	public static boolean isAvailable(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N) { if (map[i][j] == '1') return true; }
		return false;
	}

	static Point[] getAdjV(Point p) {
		int r = p.r, c = p.c;
		Point[] ret = new Point[4];
		ret[0] = (isAvailable(r - 1, c)) ? new Point(r - 1, c) : null;
		ret[1] = (isAvailable(r + 1, c)) ? new Point(r + 1, c) : null;
		ret[2] = (isAvailable(r, c - 1)) ? new Point(r, c - 1) : null;
		ret[3] = (isAvailable(r, c + 1)) ? new Point(r, c + 1) : null;
		return ret;

	}

	public static void bfs(Point V) {
		Queue<Point> q = new LinkedList<>();
		int num = 1;
		map[V.r][V.c] = '0';
		Point cur = V;

		while (true) {
			for (Point vertex : getAdjV(cur)) {
				if (vertex == null) continue;
				q.add(vertex);
				map[vertex.r][vertex.c] = '0';
				num++;
			}
			if (!q.isEmpty()) cur = q.remove();
			else break;
		}
		houses.add(num);

	}

	public static void main(String[] args) throws IOException {
		houses.clear();
		sb.setLength(0);
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { if (map[i][j] == '1') bfs(new Point(i, j)); } }

		Collections.sort(houses);

		sb.append(houses.size()).append('\n');
		for (int num : houses)
			sb.append(num).append('\n');
		System.out.print(sb.toString());

	}

}
