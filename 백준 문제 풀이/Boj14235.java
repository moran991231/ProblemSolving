package adsf;

import java.io.*;
import java.util.*;

class Boj14235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		PriorityQueue<Integer> santa = new PriorityQueue<>(Collections.reverseOrder());
		int N = stoi(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			if(a==0) {
				if(santa.isEmpty())
					sb.append(-1);
				else
					sb.append(santa.remove());
				sb.append('\n');
			}else {
				for(int i=0; i<a; i++)
					santa.add(stoi(st.nextToken()));
			}
		}
		System.out.println(sb.toString());
	}

}
