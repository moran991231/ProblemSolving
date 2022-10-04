package done;

import java.io.*;
import java.util.*;

class Boj_2629 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] chu;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	static int sum = 0;

	static void make_dp() {
		sum = 0;
		int temp = 0;
		for (int c : chu) sum += c;
		Arrays.sort(chu);
		dp = new int[N][sum + 1];

		for (int i = chu[0]; i <= sum; i++)
			dp[0][i] = chu[0];

		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= sum; j++) {
				temp = (j - chu[i]) >= 0 ? (dp[i - 1][j - chu[i]] + chu[i]) : chu[i];
				dp[i][j] = Math.max(dp[i - 1][j], (temp <= j) ? temp : 0);
			}
		}

	}

	static char check(int bead) {
		int[] dp_N = dp[N - 1];
		if (bead > sum) return 'N';
		if (dp_N[bead] == bead) return 'Y';
		for (int w = bead + 1, gap = 0; w <= sum; w++) {
			gap = dp_N[w] - bead;
			if (gap < 0) continue;
			if (dp_N[gap] == gap) return 'Y';
		}
		return 'N';
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = Integer.parseInt(br.readLine());
		chu = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			chu[i] = Integer.parseInt(st.nextToken());
		make_dp();

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int bead = Integer.parseInt(st.nextToken());
			sb.append(check(bead)).append(' ');
		}
		System.out.println(sb.toString());

	}

}
