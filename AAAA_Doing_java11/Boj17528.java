import java.io.*;
import java.util.*;

class Boj17528 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] task;
	static final int MAX = 250 * 250 + 1, A = 0, B = 1;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int solve() {
		int[] dp = new int[MAX], pre = new int[MAX], temp;
			
		Arrays.fill(pre, MAX);
		int a,b, totalA=0, totalB=0;

		for(int i=0; i<N; i++) {
			a = task[i][A];
			b=task[i][B];
			totalA+=a;
			totalB+=b;
			
			for(int j=0; j<MAX;j++) {
				if(j>=totalA)
					dp[j]=0;
				else {
					dp[j] = Math.min(pre[j]+b, (j-a>=0)? pre[j-a]:totalB);
				}
			}
			
			//swap
			temp=dp;
			dp=pre;
			pre=temp;
		}
		

		int min=MAX;
		for(int i=0; i<MAX;i++)
			min = Math.min(min, Math.max(i, pre[i]));
		return min;
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		task = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			task[i][A] = stoi(st.nextToken());
			task[i][B] = stoi(st.nextToken());
		}

		System.out.println(solve());
	}
}
