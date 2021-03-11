package done;

import java.io.*;
import java.util.*;

class Boj_4803 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int N, M, num, cnt;
	static ArrayList<Integer>[] edges;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean read() {

		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			if(N==0) return false;
			num=cnt=0;
			edges = new ArrayList[N+1];
			visited = new int[N+1];
			for(int i=1; i<=N; i++) edges[i] = new ArrayList<Integer>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = stoi(st.nextToken()), b = stoi(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
		} catch (IOException e) {
			return false;
		}

		return true;
	}
	
	static void countTrees() {
		for(int i=1; i<=N; i++) {
			if(visited[i]==0) {
				if(bfs(i)) cnt++;
			}
		}
	}
	
	static boolean bfs(int start) {
		num++;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]=num;
		boolean ret=true;
		
		 while(! q.isEmpty()) {
			 int node = q.remove();
			 for(int i=0; i<edges[node].size();) {
				 int next = edges[node].get(i);
				 if(visited[next]==0) {
					 visited[next] = num;
					 q.add(next);
				 }else {
					 ret=false;
				 }
				 edges[node].remove((Integer)next);
				 edges[next].remove((Integer)node);
			 }
		 }
		return ret;
	}
	
	static void print(int i) {
		String s1 = String.format("Case %d: ", i);
		sb.append(s1);
		if(cnt==0) s1 = "No trees.\n";
		else if (cnt==1) s1="There is one tree.\n";
		else s1 = String.format("A forest of %d trees.\n", cnt);
		sb.append(s1);
	}

	public static void main(String[] args) {
		sb.setLength(0);
		for(int i=1; ; i++) {
			if(read()==false) break;
			countTrees();
			print(i);
		}
		System.out.println(sb.toString());
	}

}
