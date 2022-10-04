package qwer;

import java.io.*;
import java.util.*;

class Main_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;

	static Call[] calls1;

	static class Call {
		int start, end;

		

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		
		st = new StringTokenizer(br.readLine()	);
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		calls1 = new Call[N];
		for(int i=0; i<N; i++) {
			String[] tokens = br.readLine().split(" ");
			Call c = new Call();
			c.start = stoi(tokens[2]);
			c.end = c.start + stoi(tokens[3]);
			calls1[i]=c;
			
		}
		
		for(int i=0; i<N; i++) {
			int cnt=0;
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken()), end = stoi(st.nextToken());
			Arrays.sort(calls1,
					(x,y)->(x.start==y.start)? 
							x.end-y.end:
								x.start-y.start);
			Call a = new Call();
			a.start=start;
			int u = Arrays.binarySearch(calls1, a,(x,y)->(x.start==y.start)? 
					x.end-y.end:
						x.start-y.start);
			u = ~u;
			a.start=end;
			int v = Arrays.binarySearch(calls1, a,(x,y)->(x.start==y.start)? 
					x.end-y.end:
						x.start-y.start);
			v = ~v;
			cnt += v-u;
			
			Arrays.sort(calls1,0,u,(x,y)->(x.end==y.end)? x.start-y.start:x.end-y.end);
			a .start=0;
			a.end = start+1;
			u = Arrays.binarySearch(calls1,0,u,a,(x,y)->(x.end==y.end)? x.start-y.start:x.end-y.end);
			u= ~u;
			a.end=end+1;
			v = Arrays.binarySearch(calls1, 0,u,a,(x,y)->(x.end==y.end)? x.start-y.start:x.end-y.end);
			v = ~v;
			cnt += v-u;
			sb.append(cnt).append('\n');
			
		}
		System.out.println(sb.toString());
	}

}