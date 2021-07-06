import java.io.*;
import java.util.*;

class Boj18239 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static final String NO = "NO\n", YES = "YES\n", REV = "reverse %d %d\n";

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void solve() {
		if (1 < K && K < N - 1) {
			sb.append(YES);
			sb.append(String.format(REV, 1, K));
			sb.append(String.format(REV, K + 1, N));
			for (int i = 0; i < 3; i++)
				sb.append(String.format(REV, 1, N));
		} else if (N == 2) {
			sb.append(YES);
			for (int i = 0; i < 5; i++)
				sb.append(String.format(REV, 1, N));
		} else if (N == 3) {
			sb.append(NO);
		} else {
			sb.append(YES);
			if (K == 1) {
				sb.append(String.format(REV, 1, 2));
				sb.append(String.format(REV, 3, N));
				sb.append(String.format(REV, 2, N));
			} else {
				sb.append(String.format(REV, N - 1, N));
				sb.append(String.format(REV, 1, N - 2));
				sb.append(String.format(REV, 1, N - 1));
			}
			for (int i = 0; i < 2; i++)
				sb.append(String.format(REV, 1, N));

		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		solve();
		System.out.println(sb.toString());
	}
}
