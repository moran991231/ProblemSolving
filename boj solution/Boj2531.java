package round8;

import java.io.*;
import java.util.*;

class Boj2531 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, D, K, C;
	static int[] sushi;
	static int[] kind;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int eat() {
		Queue<Integer> eaten = new LinkedList<>();
		int max=0;
		int s;
		int cnt=1;
		kind[C]=1;
		
		for(int i=0; i<K; i++) {
			s=sushi[i];
			if(kind[s]==0) cnt++;
			kind[s]++;
			eaten.add(s);
		}
		
		
		max = Math.max(max, cnt);
		
		
		for(int i=K; i<N+K;i++) {
			s = eaten.remove();
			if(kind[s]==1) cnt--;
			kind[s]--;
			
			s=sushi[i%N];
			if(kind[s]==0) cnt++;
			kind[s]++;
			eaten.add(s);
			
			max = Math.max(max, cnt);
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);

		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		D = stoi(st.nextToken());
		K = stoi(st.nextToken());
		C = stoi(st.nextToken());
		sushi = new int[N];
		kind = new int[D+1];
		for (int i = 0; i < N; i++)
			sushi[i] = stoi(br.readLine());
		
		System.out.println(eat());
	}
}
