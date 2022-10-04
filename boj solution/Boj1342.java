package done;

import java.io.*;
import java.util.*;

class Boj1418 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] abcCnt;
	static int len;
	static int ret = 0;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void dfs(int pre, int depth) {
		if (depth == len) {
			ret++;
		}
		for (int i = 0; i < 26; i++) {
			if (i == pre)
				continue;
			if (abcCnt[i] == 0)
				continue;
			abcCnt[i]--;
			dfs(i, depth + 1);
			abcCnt[i]++;
		}
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		abcCnt = new int[26];
		char[] str = br.readLine().toCharArray();
		ret = 0;
		len = str.length;

		for (char ch : str) {
			abcCnt[ch - 'a']++;
		}

		dfs(-1, 0);
		System.out.println(ret);

	}

}
