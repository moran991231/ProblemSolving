import java.io.*;
import java.util.*;

class Boj15658 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, min, max;
	static int[] A, operator;
	static final int ADD=0,SUBTRACT=1,MULTIPLE=2,DIVIDE=3;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static void backTracking(int idx, int ret, int op) {
		
		if(1<=idx && idx<N)
		switch(op) {
		case ADD:
			ret += A[idx];
			break;
		case SUBTRACT:
			ret -=A[idx];
			break;
		case MULTIPLE:
			ret *= A[idx];
			break;
		case DIVIDE:
			ret /= A[idx];
			break;
		}
		idx++;
		if(idx==N) {
			min = Math.min(ret, min);
			max = Math.max(ret,max);
			return;
		}
		
		for(int i=0; i<4; i++)
			if(operator[i]>0) {
				operator[i]--;
				backTracking(idx,ret,i);				
				operator[i]++;
			}
		
		
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = stoi(st.nextToken());
		
		operator = new int[4];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<4; i++)
			operator[i] = stoi(st.nextToken());

		min=Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		backTracking(0,A[0],-1);
		System.out.println(max);
		System.out.println(min);
	}
}
