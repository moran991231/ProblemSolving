import java.io.*;
import java.util.*;

class Boj19622 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] meets;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static int solve() {
		int[][] dp=new int[N][2];
		dp[0][0]=0;
		dp[0][1]=meets[0];
		for(int i=1; i<N; i++) {
			dp[i][0]= Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = dp[i-1][0]+meets[i];
		}
		
		
		return Math.max(dp[N-1][0], dp[N-1][1]);
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		meets = new int[N];
		for(int i=0; i<N; i++) {
			String[] tokens = br.readLine().split(" ");
			meets[i] = stoi(tokens[2]);
		}
		System.out.println(solve());
	}
}
