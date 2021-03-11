package done;

import java.io.*;
import java.util.*;

class Boj_11725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] parent;
	static ArrayList<Integer>[] edges;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void findParent(){
		Queue<Integer> q = new LinkedList<Integer>();
		parent[1] =-1;
		q.add(1);
		while(!q.isEmpty()) {
			int p = q.remove();
			for(int sib: edges[p]) {
				if(parent[sib]==0) {
					parent[sib]=p;
					q.add(sib);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		N = stoi(br.readLine());
		parent = new int[N+1];
		edges = new ArrayList[N+1];
		for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b= stoi(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		findParent();
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++)
			sb.append(parent[i]).append('\n');
		System.out.println(sb.toString());
	}

}
