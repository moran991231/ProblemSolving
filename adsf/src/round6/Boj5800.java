package round6;

import java.io.*;
import java.util.*;

class Boj5800 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int K;
	static int[][] math;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		K = stoi(br.readLine());
		math = new int[K][];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int len = stoi(st.nextToken());
			math[i] = new int[len];
			for (int j = 0; j < len; j++) {
				math[i][j] = stoi(st.nextToken());
			}
			Arrays.sort(math[i]);

			int gap = 0;
			for (int j = 1; j < len; j++) {
				if (math[i][j] - math[i][j - 1] > gap) {
					gap = math[i][j] - math[i][j - 1];
				}

			}

			sb.append(String.format("Class %d\nMax %d, Min %d, Largest gap %d\n", i + 1, math[i][len - 1], math[i][0],
					gap));
		}

		System.out.println(sb.toString());

	}

}
