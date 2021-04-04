package done;

import java.io.*;

class Boj_9461 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb=new StringBuilder();
	
	static long[] dp = new long [100+1];
	static boolean dpReady=false;
	
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void make_dp() {
		dp[1]=dp[2]=1;
		
		for(int i=3; i<=100; i++) {
			dp[i] = dp[i-2]+dp[i-3];
		}
		dpReady=true;
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		if(!dpReady) make_dp();
		
		int T = stoi(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = stoi(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb.toString());
		
	}

}

