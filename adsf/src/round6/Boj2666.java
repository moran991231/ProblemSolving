package round6;

import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] loc1,loc0, sum;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int N = stoi(br.readLine());
		loc0 = new int[N+1][2];
		loc1 = new int[N+1][2];
		sum = new int[N+1][2];
		st = new StringTokenizer(br.readLine());
		loc1[0][0]=loc0[0][0]=stoi(st.nextToken());
		loc1[0][1]	 = loc0[0][1]=stoi(st.nextToken());
		
		int M = stoi(br.readLine());
		int a, b;
		for(int i=1; i<=M;i++) {
			int next = stoi(br.readLine());
			a = sum[i-1][0]+Math.abs(next-loc0[i-1][0]);
			b = sum[i-1][1]+Math.abs(next-loc1[i-1][0]);
			if(a<=b) {
				sum[i][0] = a;
				loc0[i][0]=next;
				loc1[i][0]=loc1[i-1][0];
			}else {
				sum[i][0]=b;
				loc0[i][0]=next;
				loc1[i][0]=loc1[i-1][0];
				
			}
			a= sum[i-1][1]+Math.abs(next-loc0[i-1][1]);
			b = sum[i-1][1]+Math.abs(next-loc1[i-1][1]	);
			if(a<=b) {
				sum[i][1] = a;
				loc0[i][1]=next;
				loc1[i][1]=loc1[i-1][1];
			}
			else {
				sum[i][1] = b;
				loc0[i][1]=next;
				loc1[i][1]=loc1[i-1][1];
				
			}
			
		}
		System.out.println(Math.min(sum[M][0],sum[M][1]));
		

	}

}
