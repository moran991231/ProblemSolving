package done;

import java.io.*;

class Boj_2156 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int[] wine;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int max_wine() {
		if (N == 1)
			return wine[0];
		else if (N == 2)
			return wine[0] + wine[1];

		int [][]dp = new int[N][2];
		int[]max = new int[N];

		dp[0][0] = dp[0][1] =max[0]= wine[0];
		
		dp[1][0] = wine[1];
		dp[1][1] =  max[1] =wine[0] + wine[1];
		
		dp[2][0] = wine[0] + wine[2];
		dp[2][1] = wine[1] + wine[2];
		max[2] = Math.max(dp[2][0], dp[2][1]);
		max[2]=Math.max(max[2], max[1]);

		for (int i = 3; i < N; i++) {
			dp[i][0] = wine[i] + max[i-2];
			dp[i][1] = wine[i - 1] + wine[i] + max[i-3];
			max[i] = Math.max(dp[i][0], dp[i][1]);
			max[i] = Math.max(max[i], max[i-1]);
		}
		
		int ret=0;
		for(int m: max) ret = Math.max(m, ret);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		wine = new int[N];

		for (int i = 0; i < N; i++) {
			wine[i] = stoi(br.readLine());
		}

		System.out.println(max_wine());
	}

}
