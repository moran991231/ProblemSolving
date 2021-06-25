package done;
import java.io.*;
import java.util.*;

class Boj2133 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long[] dp;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static void makeDP() {
		dp = new long[31];
		dp[0]=1;
		dp[2]=3;
		for(int i=4; i<=30; i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j=0; j<=i-4; j+=2) {
				dp[i]+= dp[j]*2;
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		if(dp==null) makeDP();
		System.out.println(dp[stoi(br.readLine())]);
	}
}
