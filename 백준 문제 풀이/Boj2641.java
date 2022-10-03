package done;

import java.io.*;
import java.util.*;

class Boj2641 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int L, N;

	static char[] orig, reverseOrig;
	static char[] test;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean solve() {
		int idx;
		for (int offset = 0; offset < L; offset++) {
			boolean isSame = true;
			for (int i = 0; i < L; i++) {
				idx = offset + i;
				if (idx >= L)
					idx -= L;

				if (orig[idx] != test[i]) {
					isSame = false;
					break;
				}
			}
			if (isSame)
				return true;
		}

		for (int offset = 0; offset < L; offset++) {
			boolean isSame = true;
			for (int i = 0; i < L; i++) {
				idx = offset + i;
				if (idx >= L)
					idx -= L;

				if (reverseOrig[idx] != test[i]) {
					isSame = false;
					break;
				}
			}
			if (isSame)
				return true;
		}

		return false;

	}

	public static void printTest() {
		for (char ch : test) {
			sb.append(ch).append(' ');
		}
		sb.append('\n');
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);

		L = stoi(br.readLine());
		orig = new char[L];
		reverseOrig = new char[L];
		test = new char[L];
		String str = br.readLine();
		for (int i = 0; i < L; i++) {
			orig[i] = str.charAt(i * 2);
			reverseOrig[L - i - 1] = (char) ((orig[i] <= '2') ? orig[i] + 2 : orig[i] - 2);
		}

		N = stoi(br.readLine());

		int cnt = 0;
		for (int n = 0; n < N; n++) {
			str = br.readLine();
			for (int i = 0; i < L; i++)
				test[i] = str.charAt(i * 2);
			if (solve()) {
				cnt++;
				printTest();
			}

		}

		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}