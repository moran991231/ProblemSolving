package done;

import java.io.*;
import java.util.*;

class Boj15805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int NONE = -100;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] path = new int[N];
		int K = 0;
		for (int i = 0; i < N; i++) {
			path[i] = stoi(st.nextToken());
			K = Math.max(K, path[i]);
		}

		int[] parent;
		parent = new int[K + 1];
		Arrays.fill(parent, NONE);
		parent[path[0]]=-1;
		for(int i=1; i<N;i++) {
			if(parent[path[i]]==NONE) {
				parent[path[i]] = path[i-1];
			}
			
		}
		sb.append(K+1).append('\n');
		for(int p:parent)
			sb.append(p).append(' ');
		System.out.println(sb.toString());

	}
}
