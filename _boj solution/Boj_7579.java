package done;

import java.io.*;
import java.util.*;

class Boj_7579 {
	static int N, M;
	static Work[] A;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st, st2;

	static class Work {
		int mem, cost;

		Work(int m, int c) {
			mem = m;
			cost = c;
		}

	}

	static int calc() {
		int cost_sum = 0;
		for (Work w : A) cost_sum += w.cost;
		int[][] dp = new int[N][cost_sum + 1];

		for (int c = 0; c <= cost_sum; c++)
			dp[0][c] = (A[0].cost <= c) ? A[0].mem : 0;

		for (int i = 1; i < N; i++) {
			for (int c = 0; c <= cost_sum; c++) {
				int temp = (c - A[i].cost >= 0) ? dp[i - 1][c - A[i].cost] + A[i].mem : 0;
				dp[i][c] = Math.max(dp[i - 1][c], temp);
			}
		}

		for (int c = 0; c <= cost_sum; c++)
			if (M <= dp[N - 1][c]) return c;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new Work[N];

		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));

		System.out.println(calc());

	}

}
