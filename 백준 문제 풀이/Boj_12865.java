package done;


import java.io.*;
import java.util.*;

public class Boj_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] WV = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			WV[i][0] = Integer.parseInt(st.nextToken());
			WV[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(WV,new Comparator<int[]>() {
			@Override
			public int compare(int[]wv1, int[]wv2) {
				return wv1[0]-wv2[0];
			}
		});
		int wi, vi;
		for(int i=1; i<=N; i++) {
			for(int w=1; w<K+1; w++) {
				wi = WV[i][0];
				vi = WV[i][1];
				dp[i][w] = Math.max(dp[i-1][w], (wi<=w)? (dp[i-1][w-wi]+vi):0); 
			}
		}

		System.out.println(dp[N][K]);

	}

}
