package round8;

import java.io.*;
import java.util.*;

class Boj2548 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int N = stoi(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = stoi(st.nextToken());
		
		Arrays.sort(A);
		
		System.out.println(A[(N-1)/2]);

	}
}
