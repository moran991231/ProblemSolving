package round7;

import java.io.*;
import java.util.*;

class Boj8834 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K,N;
	static int[] order,tree;
	static int[] pow2;
	
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static void makePow2() {
		pow2 = new int[12];
		pow2[0]=1;
		for(int i=1; i<12;i++)
			pow2[i]= pow2[i-1]*2;
	}
	
	static void visit(int s, int e,int idx) {
		int m = (s+e)/2;
		if(s==e) {
			tree[idx]=order[m];
			return;			
		}
		tree[idx]=order[m];
		visit(s,m-1,idx*2);
		visit(m+1,e,idx*2+1);
	}
	
	static void print() {
		for(int k=0; k<K;k++) {
			for(int i = pow2[k]; i<pow2[k+1];i++) {
				sb.append(tree[i]).append(' ');
			}
			sb.append('\n');
		}
	}

	public static void main(String[] args) throws IOException{
		if(pow2==null)
			makePow2();
		sb.setLength(0);
		
		K = stoi(br.readLine());
		N=  pow2[K];
		order = new int[N-1];
		tree = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N-1;i++)
			order[i] = stoi(st.nextToken());
		visit(0,N-2,1);
		print();
		System.out.print(sb.toString());
		
	}

}