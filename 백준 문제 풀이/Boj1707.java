import java.io.*;
import java.util.*;

class Boj1707 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final String YES="YES\n",NO="NO\n";
	static int V,E;
	static ArrayList<Integer>[] edges;
	static byte[] nodes;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static boolean bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		nodes[s]=1;
		q.add(s);
		while(!q.isEmpty()) {
			int cur = q.remove();
			for(int next: edges[cur]) {
				if(nodes[next] == nodes[cur]) return false;
				else if (nodes[next]==0) {
					nodes[next] = (byte) (-1*nodes[cur]);
					q.add(next);
				}
			}
		}
		return true;
	}
	static String solve() {
		for(int v=1; v<=V;v++) {
			if(nodes[v]==0)
				if(bfs(v)==false) return NO;
		}
		
		return YES;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int K = stoi(br.readLine());
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			V=stoi(st.nextToken());
			E=stoi(st.nextToken());
			edges = new ArrayList[V+1];
			nodes = new byte[V+1];
			int a,b;
			for(int i=1; i<=V;i++)
				edges[i] = new ArrayList<>();
			for(int i=0; i<E;i++) {
				st = new StringTokenizer(br.readLine());
				a=stoi(st.nextToken());
				b=stoi(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			
			sb.append(solve());
		}
		System.out.print(sb.toString());
	}
}
