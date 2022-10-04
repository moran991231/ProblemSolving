package done;
import java.io.*;
import java.util.*;

class Boj1949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, sum;
	static int[] villages;
	static int[][] dp; //dp[N+1][2]
	static boolean[] visited;
	static final int NORMAL=0, GOOD=1;
	static ArrayList<Integer>[] edges;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int dfs(int node, int normalGood) {
		if(visited[node])
			return dp[node][normalGood];
		
		visited[node]=true;
		dp[node][GOOD]=villages[node];
		for(int next : edges[node]) {
			if(visited[next])continue;
			dp[node][NORMAL] += Math.max(dfs(next,GOOD), dfs(next,NORMAL));
			dp[node][GOOD] += dfs(next,NORMAL);
			
		}
		return dp[node][normalGood];
	}
	
	

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		villages = new int[N+1];
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		edges = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			edges[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		sum=0;
		for(int i=1; i<=N; i++) {
			villages[i] = stoi(st.nextToken());
			sum += villages[i];
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		int a = dfs(1,NORMAL);
		int b = dfs(1,GOOD);
		System.out.println(Math.max(a, b));
		
	}
}
