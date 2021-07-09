import java.io.*;
import java.util.*;

class Boj4803 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,M;
	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	static final String CASE = "Case %d: %s\n", NONE="No trees.", ONE = "There is one tree.", MULT="A forest of %d trees.";
	

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int numTrees() {
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(visited[i]==false) {
				if(bfs(i))
					cnt++;
			}
		}
		return cnt;
	}
	
	static boolean bfs(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[root]=true;
		q.add(root);
		boolean isCycle=false;
		int cnt;
		while(!q.isEmpty()) {
			int cur = q.remove();
			cnt=0;
			for(int next:edges[cur])
				if(visited[next]) {
					cnt++;
				}
				else {
					visited[next]=true;
					q.add(next);
				}
			if(cnt>=2) isCycle=true;
		}
		return !isCycle;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int a,b;
		int numCase=1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			if(N==0 && M==0) break;
			edges = new ArrayList[N+1];
			visited = new boolean[N+1];
			for(int i=0; i<=N; i++)
				edges[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				a = stoi(st.nextToken());
				b = stoi(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			int num = numTrees();
			String temp = "";
			if(num==0)temp = NONE;
			else if (num==1) temp = ONE;
			else temp = String.format(MULT, num);
			sb.append(String.format(CASE, numCase++,temp));
				
		}
		System.out.println(sb.toString());

	}
}
