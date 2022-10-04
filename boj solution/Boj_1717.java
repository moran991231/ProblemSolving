package done;

import java.io.*;
import java.util.*;

class Boj_1717 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int[] parent;
	static final String YES = "YES\n", NO = "NO\n";

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void union(int a, int b) {
		int root_a = grandParent(a);
		int root_b = grandParent(b);
		parent[root_b]=root_a;
	}

	static boolean find(int a, int b) {
		int root_a = grandParent(a);
		int root_b = grandParent(b);
		parent[a] = root_a;
		parent[b] = root_b;
		
		if(root_a == root_b)
			return true;
		return false;
	}
	
	static int grandParent(int x) {
		while(parent[x] != x)
			x=parent[x];
		return x;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = stoi(st.nextToken()), M = stoi(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) { parent[i] = i; }
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = stoi(st.nextToken()), a = stoi(st.nextToken()),
				b = stoi(st.nextToken());
			if (command == 0) union(a, b);
			else if (command == 1) {
				if (find(a, b))
					sb.append(YES);
				else sb.append(NO);
			}
		}
		System.out.println(sb.toString());
	}

}
