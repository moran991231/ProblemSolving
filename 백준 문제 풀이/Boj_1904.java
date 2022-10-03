package done;


import java.io.*;

public class Boj_1904 {
	static int[] dp = new int[1_000_001];
	
	public static void make_dp() {
		dp[0]=1;
		dp[1]=1;
		for(int i=2; i<1_000_001; i++) 
			dp[i] = (dp[i-1]+dp[i-2])%15746;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (dp[0]==0) make_dp();
		System.out.println(dp[N]);

	}

}
