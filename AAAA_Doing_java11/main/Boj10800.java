package boj;

import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] balls;
	static final int COLOR=0,SIZE=1;
	static int[] cntSize; // [2001] 1~2000
	static ArrayList<Integer>[] colorSize;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void func() {
		int score;
		for(int[] ball:balls) {
			score=0;
			
		}
	}

	public static void main(String[] args) throws IOException {

		sb.setLength(0);
		N = stoi(br.readLine());
		cntSize = new int[2001];
		balls = new int[2000][2];
		colorSize = new ArrayList[N+1];
		for(int i=1; i<=N;i++) {
			colorSize[i] = new ArrayList<>();
		}
		
		int c, s;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			balls[i][COLOR] =c = stoi(st.nextToken());
			balls[i][SIZE]=s = stoi(st.nextToken());
			cntSize[s]++;
			colorSize[c].add(s);
		}
		
		for(int i=1; i<=N;i++) {
			Collections.sort(colorSize[i]);
			cntSize[i] +=cntSize[i-1]*i-1;
		}
	}
}
