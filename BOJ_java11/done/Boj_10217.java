package done;

import java.io.*;
import java.util.*;

class Boj_10217 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K;
	static ArrayList<Info>[] tickets;
	static final String FAIL = "Poor KCM\n";
	static final int INF = 1_000_0000;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Info {
		int next, cost, time;

		Info(int n, int c, int t) {
			next = n;
			cost = c;
			time = t;
		}
	}

	static class City implements Comparable<City> {
		int num, cost, time = Integer.MAX_VALUE;

		City(int n, int c, int t) {
			num = n;
			cost = c;
			time = t;
		}

		public int compareTo(City c) {
			if (time == c.time) return cost - c.cost;
			return this.time - c.time;
		}
	}

	static int dp_dijkstra() {
		int[][] dp = new int[N + 1][M + 1]; // dp[city][cost] = time
		PriorityQueue<City> q = new PriorityQueue<>();

		for (int i = 2; i <= N; i++) Arrays.fill(dp[i], INF);

		q.add(new City(1, 0, 0));
		while (!q.isEmpty()) {
			City cur = q.remove();
			int num = cur.num, cur_cost = cur.cost, cur_time = cur.time;
			if (num == N) break;
			if (dp[num][cur_cost] < cur_time) continue;

			for (Info i : tickets[num]) {
				int next = i.next, next_cost = cur_cost + i.cost,
					next_time = cur_time + i.time;

				if (next_cost > M) continue;
				if (dp[next][next_cost] > next_time) {
					for (int j = next_cost; j <= M; j++) {
						if (dp[next][j] <= next_time) break;
						dp[next][j] = Math.min(dp[next][j], next_time);
					}
					q.add(new City(next, next_cost, next_time));
				}
			}
		}

		return dp[N][M];
	}

	static void read() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		tickets = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) { tickets[i] = new ArrayList<>(); }
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int u = stoi(st.nextToken()), v = stoi(st.nextToken()),
				c = stoi(st.nextToken()), d = stoi(st.nextToken());
			tickets[u].add(new Info(v, c, d));
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int t = 0; t < T; t++) {
			read();
			int ret = dp_dijkstra();
			if (ret == INF) sb.append(FAIL);
			else sb.append(ret).append('\n');
		}
		System.out.println(sb.toString());

	}

}
