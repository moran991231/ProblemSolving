package done;

import java.io.*;
import java.util.*;

class Boj_11066 {
	int T, K;
	StringTokenizer st;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] sums;

	int get_sum(int i, int j) {
		if(i==0)return sums[j];
		return sums[j]-sums[i-1];
	}

	int calc_cost() {
		int[][] dp = new int[K][K];
		dp[0][1] = sums[1];
		for(int i=2; i<K; i++) dp[i-1][i] = sums[i]-sums[i-2];
		
		for(int gap=2; gap<K; gap++) {
			for(int i=0; i+gap<K; i++) {
				int j=i+gap;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++)
					dp[i][j] = Math.min(dp[i][k]+dp[k+1][j]+get_sum(i,j),dp[i][j]);
			}
		}
		return dp[0][K-1];
	}

	void main_func() throws IOException {
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			K = Integer.parseInt(br.readLine());
			sums = new int[K];
			st = new StringTokenizer(br.readLine());
			sums[0] = Integer.parseInt(st.nextToken());
			for (int j = 1; j < K; j++) { sums[j] = sums[j - 1] + Integer.parseInt(st.nextToken()); }
			sb.append(calc_cost()).append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		new Boj_11066().main_func();
	}

}
