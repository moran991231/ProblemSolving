package done;

import java.io.*;

class Boj_12852 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));

	static int[]op = new int[1000001];
	static int[] next = new int[1000001];
	static void make_dp() {
		op[0]=-1;
		op[1]=0;
		op[2]=1;
		op[3]=1;
		next[1]=0;
		next[2]=1;
		next[3]=1;
		
		for(int n=4; n<=1000000; n++) {
			int a,b,c,d, min;
			a=b=c=d= Integer.MAX_VALUE;
			if(n%3==0) a = 1+op[n/3];
			if(n%2==0) b = 1+op[n/2];
			c = 1+op[n-1];
			d= 2+op[n-2];
			min = Math.min(Math.min(a, b), Math.min(c, d));
			
			if(min == a) next[n] = n/3;
			else if (min == b) next[n] = n/2;
			else if (min == c) next[n] = n-1;
			else next[n] = n-2;
			op[n]=min;
		}
	}
	public static void main(String[] args) throws IOException {
		if(op[0]==0) make_dp();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(op[N]).append('\n');
		for(int n = N; 0<n; n = next[n]) {
			sb.append(n).append(' ');
			
		}
		System.out.print(sb.toString());
		
	}

}
