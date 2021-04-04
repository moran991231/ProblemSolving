package done;

import java.io.*;
import java.util.*;

class Boj_11054 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] A;
	static int[][] asc, desc;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void make_asc() {
		ArrayList<Integer> lsi = new ArrayList<>();
		lsi.add(A[0]);
		asc[0][0] = 1;
		asc[0][1] = A[0];
		for (int i = 1; i < N; i++) {
			int idx = Collections.binarySearch(lsi, A[i]);
			if (idx < 0)
				idx = -idx-1;
			if (lsi.size() <= idx)
				lsi.add(A[i]);
			else
				lsi.set(idx, A[i]);
			asc[i][0] = lsi.size();
			asc[i][1] = lsi.get(asc[i][0] - 1);
		}
	}

	static void make_desc() {
		ArrayList<Integer> lsi = new ArrayList<>();
		lsi.add(A[N - 1]);
		desc[N - 1][0] = 1;
		desc[N - 1][1] = A[N - 1];
		for (int i = N - 2; 0 <= i; i--) {
			int idx = Collections.binarySearch(lsi, A[i]);
			if (idx < 0)
				idx = -idx-1;
			if (lsi.size() <= idx)
				lsi.add(A[i]);
			else
				lsi.set(idx, A[i]);
			desc[i][0] = lsi.size();
			desc[i][1] = lsi.get(desc[i][0] - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());
		A = new int[N];
		asc = new int[N][2];
		desc = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = stoi(st.nextToken());
		}

		make_asc();
		make_desc();

		int max = Math.max(asc[N - 1][0], desc[0][0]);
		for (int i = 0; i < N; i++) {
			if (asc[i][1] == desc[i][1])
				max = Math.max(max, asc[i][0] + desc[i][0] - 1);
			else
				max = Math.max(max, asc[i][0] + desc[i][0]);
		}
		System.out.println(max);
	}

}
