package adsf;

import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] trip, parent;
	static int N,len;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static int goTrip(int cur, int next) {
		if(next==len) return next;
		if(trip[next] == parent[trip[cur]]) {
			return next;
		}
		parent[trip[next]] = trip[cur];
		return goTrip(next,next+1);
	}
	
	public static void func() {
		parent[0]=-1;
		for(int i=0; i<len-1;) {
			int temp = goTrip(i, i+1);
			i=temp;		
		}
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		len = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		trip = new int[len];
		int N=0;
		for(int i=0; i<len; i++) {
			trip[i] = stoi(st.nextToken());
			N = Math.max(N, trip[i]);
		}
		N++;
		parent = new int[N];
//		func();
		for(int i=0; i<len-1; i++) {
			if(parent[trip[i]] == trip[i+1]) continue;
			parent[trip[i+1]]=trip[i];
		}
		parent[0]=-1;
		
		System.out.println(N);
		for(int i=0; i<N; i++	)
			sb.append(parent[i]).append(' ');
		System.out.println(sb.toString());
		
	}

}
