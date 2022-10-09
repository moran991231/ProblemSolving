package done;

import java.io.*;
import java.util.*;

class Boj_17472 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static byte[][] map;
	static int num;

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Edge implements Comparable<Edge> {
		int a, b, len;

		Edge(int x, int y, int l) {
			a = x;
			b = y;
			len = l;
		}

		public int compareTo(Edge e) {
			return len - e.len;
		}
	}

	static boolean inRange(int x, int min, int max) {
		if (0 <= x && x < max) return true;
		else return false;
	}

	static void countIsland() {
		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					num++;
					bfs(i, j, (byte) num);
				}
			}
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
	}

	static void bfs(int x, int y, byte fill) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		while (!q.isEmpty()) {
			Point p = q.remove();
			int i = p.i, j = p.j;
			if (!(inRange(i, 0, N) && inRange(j, 0, M))) continue;
			if (map[i][j] == 1)
				map[i][j] = fill;
			else continue;

			q.add(new Point(i - 1, j));
			q.add(new Point(i + 1, j));
			q.add(new Point(i, j - 1));
			q.add(new Point(i, j + 1));

		}
	}

	static PriorityQueue<Edge> findEdge() {
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		int a, b, len;
		int i, j;

		// horizontal bridge
		for (i = 0; i < N; i++) {
			j = 0;
			while (j < M) {
				a = b = len = 0;
				for (; j < M; j++) {
					if (map[i][j] != 0) a = map[i][j];
					else if (a != 0) break;
				}
				for (; j < M; j++) {
					if (map[i][j] != 0) {
						b = map[i][j];
						break;
					}
					len++;
				}
				if (2 <= len && b != 0) {
					edges.add(new Edge(a, b, len));
//					System.out.printf("h: %d~%d %d \n", a,b,len);
				}

			}
		}

		// vertical bridge
		for (j = 0; j < M; j++) {
			i = 0;
			while (i < N) {
				a = b = len = 0;
				for (; i < N; i++) {
					if (map[i][j] != 0) a = map[i][j];
					else if (a != 0) break;
				}
				for (; i < N; i++) {
					if (map[i][j] != 0) {
						b = map[i][j];
						break;
					}
					len++;
				}
				if (2 <= len && b != 0) {
					edges.add(new Edge(a, b, len));
//					System.out.printf("v: %d~%d %d \n", a,b,len);
				}

			}
		}
		return edges;
	}

	static void kruskal() {
		PriorityQueue<Edge> q = findEdge();
		int[] parent = new int[num + 1]; // num == num_island+1
		for (int i = 0; i < num + 1; i++)
			parent[i] = i;
		int min_len = 0;
		num--; // num == num_island
		num--; // num == num_MSTedge == num_island-1
		while (0 < num && !q.isEmpty()) {
			Edge e = q.remove();
			int root_a = find(parent, e.a), root_b = find(parent, e.b);
			if (root_a == root_b) continue;
			parent[root_b] = root_a;
			min_len += e.len;
			num--;
		}
		if (num != 0) min_len = -1;
		System.out.println(min_len);

	}

	static int find(int[] parent, int x) {
		int p = x;
		while (parent[p] != p)
			p = parent[p];
		parent[x] = p;
		return p;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new byte[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Byte.parseByte(st.nextToken());
		}

		countIsland();
		kruskal();
	}

}
