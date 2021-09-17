package round7;

import java.io.*;
import java.util.*;

class Boj9933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	static ArrayList<char[]>[] words; // words[len]: list of char[]

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean isReversed(char[] a, char[] b) {
		int end = a.length - 1;
		for (int i = 0; i <= end; i++) {
			if (a[i] != b[end - i])
				return false;
		}
		return true;
	}

	static char findPassword(ArrayList<char[]> list) {
		int size = list.size();
		char[] a, b;
		
		for (int i = 0; i < size - 1; i++) {
			a = list.get(i);
			for (int j = i ; j < size; j++) {
				b = list.get(j);
				if (isReversed(a, b))
					return a[a.length / 2];
			}
		}
		
		return 'X';
	}

	public static void main(String[] args) throws IOException {


		int N = stoi(br.readLine());

		words = new ArrayList[14];
		for (int i = 0; i < 14; i++)
			words[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			words[str.length].add(str);
		}
		
		
		int len=0;
		char ch =0;
		for(;len<words.length;len++) {
			ch = findPassword(words[len]);
			if('a'<=ch && ch<='z') {
				break;
			}
		}
		
		System.out.printf("%d %c\n", len,ch);
	}

}