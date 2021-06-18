import java.io.*;
import java.util.*;

class Boj11727 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD=10007;
	static int[] dp ;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void makeDP() {
		dp = new int[1001];
		dp[1]=1;
		dp[2]=3;
		for(int n=3; n<=1000;n++) {
			dp[n]= (dp[n-1]+dp[n-2]*2)%MOD;
		}
	}
	public static void main(String[] args) throws IOException {
		if(dp==null) makeDP();
		int N = stoi(br.readLine());
		System.out.println(dp[N]);

	}
}
