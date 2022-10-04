package done;
import java.io.*;
import java.util.*;

class Boj12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static int[][] items;
	static final int W=0,V=1;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int fillKnapsack() {
		int[] knapsack = new int[K+1],pre= new int[K+1],temp;
		int a, b;
		for(int i=0; i<N; i++) {
			int w = items[i][W], v = items[i][V];
			for(int k=0; k<=K;k++) {
				a=pre[k];
				b=(k>=w)? pre[k-w]+v:0;
				knapsack[k] = Math.max(a, b);
			}
			//swap
			temp=knapsack;
			knapsack=pre;
			pre=temp;
					
		}
		
		return pre[K];		
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		items = new int[N][2];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			items[i][W]=stoi(st.nextToken());
			items[i][V]=stoi(st.nextToken());
		}
		
		System.out.println(fillKnapsack());
	}
}
