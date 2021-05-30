package round6;

import java.io.*;
import java.util.*;

class Boj1788 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] pos, neg;
	static final long MOD = 1_000_000_000;

	static void makeFib() {
		pos = new long[1_000_001];
		neg = new long[1_000_001];
		pos[1] = neg[1] = 1L;
		for (int i = 2; i <= 1_000_000; i++) {
			pos[i] = (pos[i - 1] + pos[i - 2])%MOD;
		}
		for (int i = 2; i <= 1_000_000; i++) {
			neg[i] = (neg[i - 2] + neg[i - 1])%MOD;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		if(pos==null)
			makeFib();
		sb.setLength(0);
		int N = stoi(br.readLine());
		if(N==0) {
			sb.append(0).append('\n').append(0);
		}
		else if(N>0){
			sb.append(1).append('\n').append(pos[N]);
		}else if((-N)%2==1) {
			sb.append(1).append('\n').append(neg[-N]);
		}else {
			sb.append(-1).append('\n').append(neg[-N]);
		}
		System.out.println(sb.toString());
	}

}
