package round6;

import java.io.*;
import java.util.*;

class Boj14225 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] S;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
		
	}
	
	static int solve() {
		if(S[0]!=1)
			return 1;
		int sum=1;
		for(int i=1; i<N;i++) {
			if(sum+1>=S[i])
				sum+=S[i];
			else
				break;
		}
		return sum+1;
	}

	public static void main(String[] args) throws IOException{

		N = stoi(br.readLine());
		S = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			S[i] = stoi(st.nextToken());
		
		Arrays.sort(S);
		
		System.out.println(solve());
		
	}

}
