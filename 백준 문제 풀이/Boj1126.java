package done;
import java.io.*;
import java.util.*;

class Boj1126 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] blocks;
	static final int MAX = 250000;
	static int[][] dp ;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}


	static int solve() {
		int block, x;
		int[] pre, cur;
		for(int i=1; i<=N; i++	) {
			block =blocks[i];
			pre=dp[i-1];
			cur=dp[i];
			for(int j=0; j<=MAX;j++) {
				if(j!=0 && pre[j]==0) continue;
				cur[j]= getMax(cur[j],pre[j]	);
				x=j+block;
				if(x<=MAX)
					cur[x] = getMax(cur[x], pre[j]+block);
				x=(j-block);
				if(0<=x)
					cur[x] = getMax(cur[x], pre[j]);
				else if ((x=abs(x))<=MAX)
					cur[x] = getMax(cur[x],pre[j]+x);				
			}
		}
		
		
		return dp[N][0]>0? dp[N][0]:-1;
	}
	
	static int getMax(int ...nums) {
		int max = nums[0];
		for(int n: nums)
			if(n>max) max=n;
		
		return max;
	}
	static int abs(int x) {
		return  x>0?x:-x;
	}
	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		dp= new int[N+1][MAX+1];
		blocks = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			blocks[i] = stoi(st.nextToken());

		System.out.println(solve());
	}
}
