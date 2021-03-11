package done;

import java.io.*;
import java.util.*;

class Boj_1806 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int N, S;
	static int[] A;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

		int i = 0, j = -1, min_len = 100_001, sum = 0;
		while(j<N) {
			if(sum<S) {
				j++;
				if(N<=j) break;
				sum+=A[j];
			}
			if(S<=sum && i<=j) {
				min_len = Math.min(min_len, j-i+1);
				sum -= A[i];
				i++;
			}
		}
		if(S<=sum)
			min_len = Math.min(min_len, j-i+1);
			
		
		
		if (min_len == 100_001) min_len =0;
		System.out.println(min_len);
	}

}
