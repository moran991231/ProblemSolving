package round5;

import java.io.*;
import java.util.*;

class Boj2012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		int  N = stoi(br.readLine());
		int[] rank = new int[N+1];
		for(int i=1; i<=N;i++)
			rank [i] = stoi(br.readLine());
		Arrays.sort(rank);
		long ret=0;
		for(int i=1; i<=N; i++)
			ret +=Math.abs(i-rank[i]);
		System.out.println(ret);
		
	}

}
