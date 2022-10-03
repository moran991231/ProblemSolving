package done;

import java.io.*;
import java.util.*;

class Boj_2263 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int N;
	static int[]  in, post, in_indexOf;
	static StringBuilder sb = new StringBuilder();

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void toPre( int in_s, int in_e, int post_s, int post_e) {
		if(post_e<0) return;
		int root  = post[post_e]; // root
		sb.append(root).append(' ');
		int l_num = in_indexOf[root]-in_s;

		if (0<l_num)
			toPre( in_s, in_s + l_num - 1, post_s,
				post_s + l_num - 1);

		if (l_num + in_s < in_e)
			toPre( in_s + l_num + 1, in_e,
				post_s + l_num, post_e - 1);

	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		N = stoi(br.readLine());

		in = new int[N];
		post = new int[N];
		in_indexOf = new int[N+1];
		StringTokenizer st1 = new StringTokenizer(br.readLine()),
			st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = stoi(st1.nextToken());
			in_indexOf[in[i]] = i;
			post[i] = stoi(st2.nextToken());
		}
		toPre(0,N-1, 0,N-1);
		
		System.out.println(sb.toString());

	}

}
