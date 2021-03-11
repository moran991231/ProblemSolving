package done;

import java.io.*;
import java.util.*;

class Boj_11780 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static CityPath[][] floyd;
	static final int INF = 10_000_001;

	static class CityPath {
		int dist = INF;
		ArrayList<Integer> path = new ArrayList<>();

		void setPath(ArrayList<Integer> p1, ArrayList<Integer> p2) {
			path.clear();
			path.addAll(p1);
			path.addAll(p2);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void make_floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (floyd[i][k].dist
						+ floyd[k][j].dist < floyd[i][j].dist) {
						floyd[i][j].dist = floyd[i][k].dist + floyd[k][j].dist;
						floyd[i][j].setPath(floyd[i][k].path, floyd[k][j].path);
					}
				}
			}
		}
	}

	static String floydToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (floyd[i][j].dist == INF) floyd[i][j].dist = 0;
				sb.append(floyd[i][j].dist == INF ? 0 : floyd[i][j].dist)
					.append(' ');
			}
			sb.append('\n');
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (floyd[i][j].dist == 0) sb.append(0);
				else {
					sb.append(floyd[i][j].path.size() + 1).append(' ');
					sb.append(i).append(' ');
					for (int n : floyd[i][j].path)
						sb.append(n).append(' ');
				}
				sb.append('\n');
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		M = stoi(br.readLine());

		floyd = new CityPath[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				floyd[i][j] = new CityPath();
			floyd[i][i].dist = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken()),
				c = stoi(st.nextToken());
			if (floyd[a][b].dist == INF)
				floyd[a][b].path.add(b);
			floyd[a][b].dist = Math.min(floyd[a][b].dist, c);
		}

		make_floyd();
		System.out.println(floydToString());

	}

}
