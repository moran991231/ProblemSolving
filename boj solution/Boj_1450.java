package done;

import java.io.*;
import java.util.*;

class Boj_1450 {
	static BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
	static int N, C;
	static int[] W;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int upperBound(ArrayList<Long> sums, long target) {
		int s = 0, e = sums.size() - 1, p = -1;
		if (target < sums.get(s)) return -1;
		else if (sums.get(e)<=target) return e;
		while (s <= e ) {
			p = (s + e+1) / 2;
			if (sums.get(p) <= target) {
				if (p == s) break;
				s = p;
			} else e = p - 1;
		}
		return p;

	}

	static ArrayList<Long> subSum(int s, int e) {
		ArrayList<Long> sums = new ArrayList<>((int) Math.pow(2, e - s + 1));
		sums.add(0L);
		for (int i = s; i <= e; i++) {
			int sums_size = sums.size();
			for (int j = 0; j < sums_size; j++)
				sums.add(sums.get(j) + W[i]);
		}
		return sums;

	}

	static int countCase() {
		ArrayList<Long> a, b;
		a = subSum(0, (N - 1) / 2);
		b = subSum((N - 1) / 2 + 1, N - 1);
		Collections.sort(b);
		int a_size = a.size(), cnt = 0;
		for (int i = 0; i < a_size; i++) {
			cnt += upperBound(b, C - a.get(i)) + 1;

		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = new int[N];
		for (int i = 0; i < N; i++) W[i] = stoi(st.nextToken());

		System.out.print(countCase());
	}

}
