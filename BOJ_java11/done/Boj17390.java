package done;

import java.io.*;
import java.util.*;

class Boj17390 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void answer(int l, int r, int[] A) {
		sb.append(A[r]-A[l-1]).append('\n');
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken()), Q = stoi(st.nextToken());
		int[]A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = stoi(st.nextToken());
		}
		Arrays.sort(A);
		for(int i=1; i<=N; i++)
			A[i] += A[i-1];
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			answer(stoi(st.nextToken()), stoi(st.nextToken()),A);
		}
		
		System.out.println(sb.toString());
	}

}