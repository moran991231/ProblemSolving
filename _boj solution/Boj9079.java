package adsf;

import java.io.*;
import java.util.*;

class Boj9079 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dp = null;
	static final int[] mask = { 7, 56, 448, 73, 146, 292, 273, 84 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void makeDP() {
		dp = new int[512];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dfs(0, 0);
		dfs(511, 0);

	}

	public static void dfs(int coin, int cnt) {
		if (dp[coin] <= cnt)
			return;
		dp[coin] = cnt;

		for (int m : mask)
			dfs(coin ^ m, cnt + 1);

	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		if (dp == null)
			makeDP();

		int T = stoi(br.readLine());
		String line;
		for (int t = 0; t < T; t++) {
			int coin = 0;
			for (int i = 0; i < 3; i++) {
				line = br.readLine();
				for (int j = 0; j < 3; j++) {
					coin = coin << 1;
					if (line.charAt(j * 2) == 'H')
						coin |= 1;
				}
			}

			if (dp[coin] == Integer.MAX_VALUE)
				sb.append(-1).append('\n');
			else
				sb.append(dp[coin]).append('\n');

		}
		System.out.println(sb.toString());
	}

}
