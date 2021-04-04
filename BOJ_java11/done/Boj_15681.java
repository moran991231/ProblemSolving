package done;

import java.io.*;
import java.util.*;

class Boj_15681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, R, Q;
	static TreeMap<Integer, Integer> edges = new TreeMap<>();
	static Node[] nodes;
	
	static class Node{
		int cnt;
		ArrayList<Node> children = new ArrayList<>();
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int familyRegistry(Node parent, Node me) { //dfs
		int cnt=1;
//		if(parent != null)
//			me.children.remove(parent);
		
		for(Node child: me.children)
			if(child != parent)
				cnt += familyRegistry(me, child);
		me.cnt = cnt;
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		edges.clear();
		st = new StringTokenizer(br.readLine());
		
		N =stoi(st.nextToken());
		R = stoi(st.nextToken());
		Q = stoi(st.nextToken());
		
		nodes = new Node[N+1];
		for(int i=0; i<=N; i++) nodes[i] = new Node();
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()), b = stoi(st.nextToken());
			nodes[a].children.add(nodes[b]);
			nodes[b].children.add(nodes[a]);
		}
		
		familyRegistry(null, nodes[R]);
		
		for(int i=0; i<Q; i++) {
			int query = stoi(br.readLine());
			sb.append(nodes[query].cnt).append('\n');
		}
		System.out.print(sb.toString());
		
	}

}
