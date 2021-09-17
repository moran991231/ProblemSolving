package round8;

import java.io.*;
import java.util.*;

class Boj2954 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
	static boolean[] isVowel;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void makeIsVowel() {
		isVowel = new boolean[26];
		for (char v : vowels)
			isVowel[v - 'a'] = true;
	}

	public static void main(String[] args) throws IOException {
		if (isVowel == null)
			makeIsVowel();
		sb.setLength(0);

		char[] str = br.readLine().toCharArray();

		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			if (str[i] == ' ')
				continue;
			if (isVowel[str[i] - 'a']) {
				i+=2;
			}

		}
		
		System.out.println(sb.toString());

	}
}
