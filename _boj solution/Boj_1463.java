package done;

import java.io.*;

class Boj_1463 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int[] dp = new int[1_000_001];
	
	static void make_dp() {
		dp[0]=1;
//		dp[1]=0;
		dp[2]=dp[3]=1; 
		for(int i=4; i<=1_000_000; i++) {
			int temp1 = Integer.MAX_VALUE, temp2 = Integer.MAX_VALUE, temp3 = Integer.MAX_VALUE;
			if(i%2==0) temp1 = dp[i/2]+1;
			if(i%3==0) temp2 = dp[i/3]+1;
			temp3 = dp[i-1]+1;
			dp[i] = Math.min(temp1, Math.min(temp2, temp3));			
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		if(dp[0]==0) make_dp();
		int X = stoi(br.readLine());
		System.out.println(dp[X]);
	}

}

