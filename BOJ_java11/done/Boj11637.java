package done;

import java.io.*;
import java.util.*;

class Boj11637 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final String MAJW = "majority winner ", MINW = "minority winner ", NW = "no winner\n";

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Cand implements Comparable<Cand> {
		int idx, val;

		Cand(int i, int v) {
			idx = i;
			val = v;
		}

		public int compareTo(Cand c) {
			return this.val - c.val;
		}

	}

	static void solve(int N) throws IOException {
		int total = 0, temp;
		PriorityQueue<Cand> pq = new PriorityQueue<>();
		pq.add(new Cand(0, 0));
		pq.add(new Cand(0, 0));
		for (int i = 1; i <= N; i++) {
			temp = stoi(br.readLine());
			total += temp;
//			if (pq.peek().val < temp) {
				pq.add(new Cand(i, temp));
				pq.remove();
//			}

		}
		Cand second = pq.remove(), first = pq.remove();
		if (total < first.val * 2) {
			sb.append(MAJW).append(first.idx).append('\n');
		} else if (first.val == second.val) {
			sb.append(NW);
		} else
			sb.append(MINW).append(first.idx).append('\n');
		;
	}

	public static void main(String[] args) throws IOException {
		sb.setLength(0);
		int T = stoi(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = stoi(br.readLine());
			solve(N);
		}
		System.out.println(sb.toString());

	}

}