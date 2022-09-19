package done;
import java.io.*;
import java.util.*;

class Boj7579_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] apps;
	static final int MEM=0,COST=1;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int solve() {
		Arrays.sort(apps, (a,b)->(a[MEM]-b[MEM]));
		int[] dp = new int[M+1], pre= new int[M+1], temp;
		Arrays.fill(pre, 100000);
		pre[0]=0;
		int m,c;
		for(int i=0; i<N; i++) {
			m = apps[i][MEM];
			c = apps[i][COST];
			for(int j=1; j<=M;j++) {
				dp[j] = Math.min(pre[j], j>=m? pre[j-m]+c:c);
			}
			
			//swap
			temp=dp;
			dp=pre;
			pre=temp;
		}
		
		
		return pre[M]	;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		apps = new int[N][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			apps[i][MEM] = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			apps[i][COST] = stoi(st.nextToken());
		System.out.println(solve());
		
	}
}
