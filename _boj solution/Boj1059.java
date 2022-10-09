package round5;

import java.io.*;
import java.util.*;

class Boj1059 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L,n;
	static int[] S;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int cntGoodness() {

		int idx = Arrays.binarySearch(S, n);
		if(idx>=0)return 0;
		idx= ~idx;
		int a=0,b=0;
		if(idx==0) {
			a=1;
			b=S[idx]-1;
		}else {
			a=S[idx-1]+1;
			b=S[idx]-1;
			
		}
		if(a>=b)return 0;
		a = n-a+1;
		b= b-n+1;
		return (a*b)-1;
	}

	public static void main(String[] args) throws IOException{
		sb.setLength(0);
		L = stoi(br.readLine());
		S = new int[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<L;i++)
			S[i] = stoi(st.nextToken());
		n = stoi(br.readLine());
		Arrays.sort(S);
		
		
		System.out.println(cntGoodness());
		
	}

}
