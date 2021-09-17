package round8;

import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		char[] str = br.readLine().toCharArray();
		int s = 0, e;
		
		for (int k = K; 0 < k; k--) {
			e = N - k;
			int max = '0', max_i = s;
			
			for (int i = s; i <= e; i++) {
				if (str[i] > max) {
					max = str[i];
					max_i = i;
				}
			}
			
			sb.append(max-'0');
			s=max_i+1;

		}
		System.out.println(sb.toString()	);

	}
}
