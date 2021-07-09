import java.io.*;
import java.util.*;

class Boj9934 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] order;
	static int K,N;
	static ArrayList<Integer>[] levels;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void simulate(int b, int e, int level) {
		if(b==e) {
			levels[level].add(order[b]);
			return;
		}
		
		int m = (b+e)/2;
		levels[level].add(order[m]);
		level++;
		simulate(b,m-1,level);
		simulate(m+1,e,level);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		K = stoi(br.readLine());
		levels = new ArrayList[K];
		for(int i=0; i<K; i++)
			levels[i] = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		N=(int)Math.pow(2, K)-1;
		order = new int[N];
		for(int i=0; i<N; i++)
			order[i] = stoi(st.nextToken());
		
		simulate(0,N-1,0);

		for(ArrayList<Integer> list:levels) {
			for(int node:list)
				sb.append(node).append(' ');
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
