package round8;

import java.io.*;
import java.util.*;

class Boj9237 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N ;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		
		N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		int trees[] = new int[N];
		int tree,min=Integer.MAX_VALUE, max=0;
		for(int i=0; i<N; i++) {
			trees[i]=tree= stoi(st.nextToken());

		}
		Arrays.sort(trees);
		int additionalDay=0;
		for(int i=N-1; 0<=i;i--) {
			additionalDay = Math.max(trees[i]-(i+1), additionalDay);
		}
		System.out.println(N+additionalDay+2);
	}
}
