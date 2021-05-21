package done;

import java.io.*;
import java.util.*;

class Boj14719 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int H,W;
	static int[] block, max1,max2;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		H = stoi(st.nextToken());
		W = stoi(st.nextToken());
		block = new int[W+2];
		max1 = new int[W+2];
		max2 = new int[W+2];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=W;i++)
			block[i] = stoi(st.nextToken());
		
		for(int i=1; i<=W;i++) {
			max1[i] = Math.max(max1[i-1], block[i]);
		}
		for(int i=W; 0<=i;i--) {
			max2[i] = Math.max(max2[i+1], block[i]);
		}
		
		int water=0;
		int tempWater;
		for(int i=2; i<W;i++) {
			tempWater = Math.min(max1[i-1], max2[i+1])-block[i];
			if(tempWater>0)
				water+=tempWater;
			
		}
		System.out.println(water);

	}
}
